package fi.oamk.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fi.oamk.loginform.ui.theme.LoginFormTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginFormTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(
            text = "Login",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp) ,
            color = MaterialTheme.colorScheme.primary,
        )

        // Username Input with icon on the right
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Username") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Username Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Input without visual transformation
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Password") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Password Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* submit logic */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    LoginFormTheme {
        LoginForm()
    }
}
