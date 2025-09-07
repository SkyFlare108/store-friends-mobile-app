package com.example.firstprogrammingassignment.db.helper

import android.util.Log
import java.sql.DriverManager

object DatabaseHelper {

    private const val DATABASE_NAME = "friends"
    private const val HOST = "store-names.cho6ggogind9.us-east-2.rds.amazonaws.com"
    private const val USERNAME = "admin"
    private const val PASSWORD = "Snanum108$"
    private const val TABLE_NAME = "names"

    private const val JDBC_URL = "jdbc:mysql://$HOST:3306/$DATABASE_NAME?useSSL=true&verifyServerCertificate=false"

    fun addFriend(name: String) {
        Thread {
            try {
                Class.forName("com.mysql.jdbc.Driver")
                DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD).use { conn ->
                    conn.createStatement().use { stmt ->
                        val sql = "INSERT INTO $TABLE_NAME (name) VALUES ('$name')"
                        stmt.executeUpdate(sql)
                    }
                }
                // Log success and use to send notification to UI
            } catch (e: Exception) {
                Log.e("DatabaseHelper", "Error inserting data", e)
            }
        }.start()
    }
}