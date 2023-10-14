package com.example.signup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface,
                ) {
//                    Greeting("Android")
                    ElevatedCardExample()
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun ElevatedCardExample() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val passwordFocusRequester= FocusRequester()

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.size(width = 360.dp, height = 560.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Sign In Text
                    Text(
                        text = "Sign In",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp),
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()

                    )

                    // Login Text
                    Text(
                        text = "Login to your app",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier
                            .padding(16.dp)
                    )

                    // Email Input Field
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next // Set the IME action to Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                // Move the focus to the next field (in this case, the password field)
                                passwordFocusRequester.requestFocus()
                            }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(10.dp)) // Apply rounded corners
                            .background(Color.Transparent)
                    )

                    // password Input Field
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next // Set the IME action to Next
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                // Move the focus to the next field (in this case, formSubmit
                                signUp() // Trigger the form submission action
                            }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(10.dp)) // Apply rounded corners
                            .background(Color.Transparent)
                            .focusRequester(passwordFocusRequester) // Assign a focus requester
                    )

                    // Button Section
                    // Sign In Button (Filled)

                    Button(
                        onClick = {
                               signUp() /* Handle sign-in */
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text( "Sign In")
                    }

                    // Sign Up Button (Outlined)
                    OutlinedButton(
                        onClick = {
                            signIn()/* Handle sign-up */
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text( "Sign Up")
                    }

                    // "Forgot Password?" Text
                    Text(
                        text = "Forgot Password?",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }

            }

        }
    }

// Function to handle sign-up action (e.g., create user account)
private fun signUp() {
    // Perform sign-up action, e.g., validating and creating a user account
}

// Function to handle sign-in action (e.g., move to the app)
private fun signIn() {
    // Perform sign-in action, e.g., navigate to the main app
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    SignupTheme {
//        Greeting("Android")
        ElevatedCardExample()

    }
}