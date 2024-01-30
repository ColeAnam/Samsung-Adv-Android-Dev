package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
//    username: String,
//    email: String,
//    id: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

        var usernameState by remember {
            mutableStateOf("")
        }

        var emailState by remember {
            mutableStateOf("")
        }

        var idState by remember {
            mutableStateOf("")
        }

        val onUsernameChange = { text: String -> usernameState = text }
        val onEmailChange = { text: String -> emailState = text }
        val onIDChange = { text: String -> idState = text }

        Inputs(
            username = usernameState,
            email = emailState,
            id = idState,
            onUsernameChange = onUsernameChange,
            onEmailChange = onEmailChange,
            onIDChange = onIDChange
        )
    }
}

@Composable
fun Inputs(
    username: String,
    email: String,
    id: String,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onIDChange: (String) -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = username,
            onValueChange = { onUsernameChange(it) },
            singleLine = true,
            label = {
                Text("Username")
            }
        )
        OutlinedTextField(
            value = email,
            onValueChange = { onEmailChange(it) },
            singleLine = true,
            label = {
                Text("Email")
            }
        )
        OutlinedTextField(
            value = id,
            onValueChange = { onIDChange(it) },
            singleLine = true,
            label = {
                Text("ID")
            }
        )
    }
}

@Composable
fun Buttons() {
    Row(verticalAlignment = Alignment.CenterVertically) {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Assignment1Theme {
        MainScreen(

        )
    }
}