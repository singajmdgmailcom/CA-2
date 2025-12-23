package com.cscorner.intentcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cscorner.intentcompose.ui.theme.IntentcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentcomposeTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {

    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Username")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text("Password")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("Actions")
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                val intent = Intent(context, Second::class.java)
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        )
        {
            Text("Go to Next Screen")
        }
    }
}
