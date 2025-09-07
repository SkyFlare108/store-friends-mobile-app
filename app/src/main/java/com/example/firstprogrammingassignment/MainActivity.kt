package com.example.firstprogrammingassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstprogrammingassignment.db.helper.DatabaseHelper
import com.example.firstprogrammingassignment.ui.theme.FirstProgrammingAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstProgrammingAssignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Harisri Yerramsetti",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val friendName = remember { mutableStateOf("") }
    Column(modifier = modifier.padding(100.dp)) {
        Text(
            text = "Hello $name!",
        )

        Text("Enter the name of a new friend you made today", modifier = Modifier.padding(top = 40.dp))

        TextField(
            value = friendName.value,
            onValueChange = {friendName.value = it},
            placeholder = { Text("New Friend's Name") },
            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp)
        )

        Button(onClick = {
            DatabaseHelper.addFriend(friendName.value)
        }) {
            Text("Submit")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstProgrammingAssignmentTheme {
        Greeting("Harisri Yerramsetti")
    }
}