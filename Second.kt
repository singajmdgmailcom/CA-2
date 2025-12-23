package com.cscorner.intentcompose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cscorner.intentcompose.ui.theme.IntentcomposeTheme

class Second : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username")
        val userType = intent.getStringExtra("usertype").takeIf { !it.isNullOrEmpty() } ?: "Student"

        setContent {
            IntentcomposeTheme {
                SecondScreen(username, userType)
            }
        }
    }
}

@Composable
fun SecondScreen(username: String?, userType: String?) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Actions",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Transferred Data",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Username: $username",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "User Type: $userType",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(40.dp))


        Text(
            text = "Actions",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { val intent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com"));
            context.startActivity(intent) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Open Play Store")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { val intent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://wa.me/"));
            context.startActivity(intent) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Open WhatsApp")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { val intent = Intent(Intent.ACTION_SENDTO,
            Uri.parse("mailto:"));
            context.startActivity(intent) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Send Email")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { val intent = Intent(Intent.ACTION_SENDTO,
            Uri.parse("smsto:"));
            context.startActivity(intent) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Send SMS")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { val intent = Intent(Settings.ACTION_SETTINGS);
            context.startActivity(intent) },
            modifier = Modifier.fillMaxWidth()) {
            Text("Open Device Settings")
        }
    }
}
