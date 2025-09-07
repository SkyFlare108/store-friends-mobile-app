package com.example.firstprogrammingassignment.db.helper

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


data class AddFriendRequest(val name: String)
data class AddFriendResponse(val ok: Boolean, val id: Long?)

private interface FriendsApi {
    @POST("friends")
    fun addFriend(@Body req: AddFriendRequest): Call<AddFriendResponse>
}

private object ApiClient {
    private const val URL = "https://qa99jyz2si.execute-api.us-east-2.amazonaws.com/"

    private val client = OkHttpClient.Builder().build()

    val apiInstance: FriendsApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(FriendsApi::class.java)
    }
}

object DatabaseHelper {

    fun addFriend(name: String, onResult: (Boolean) -> Unit) {
        if (name.trim().isEmpty()) {
            onResult(false)
            return
        }

        val call = ApiClient.apiInstance.addFriend(AddFriendRequest(name.trim()))
        call.enqueue(object : Callback<AddFriendResponse> {
            override fun onResponse(call: Call<AddFriendResponse>, response: Response<AddFriendResponse>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    onResult(body?.ok == true)
                } else {
                    Log.e("DatabaseHelper", "API Error: ${response.code()} ${response.message()}")
                    onResult(false)
                }
            }

            override fun onFailure(call: Call<AddFriendResponse>, t: Throwable) {
                Log.e("DatabaseHelper", "API Call Failure", t)
                onResult(false)
            }
        })
    }

}