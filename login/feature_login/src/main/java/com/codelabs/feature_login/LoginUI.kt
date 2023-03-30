package com.codelabs.feature_login

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.codelabs.core_ui.calibre
import com.codelabs.core_ui.gotham
import com.codelabs.core_ui.textColorPrimary
import com.codelabs.core_ui.textColorSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onSignInPressed: () -> Unit,
    onSignUpPressed: () -> Unit
) {
    val context = LocalContext.current
    var password = rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.good_morning_img),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = buildAnnotatedString {
                    append("Good ")
                    withStyle(style = SpanStyle(textDecoration = Underline)) {
                        append("Morning")
                    }
                },
                modifier = Modifier
                    .padding(vertical = 80.dp)
                    .wrapContentWidth()
                    .wrapContentHeight(Alignment.Top)
                    .align(Alignment.TopCenter),
                fontSize = 32.sp,
                color = textColorPrimary,
                fontFamily = gotham
            )

            Text(
                text = "We pursue a relaxed gaming experience",
                modifier = Modifier
                    .padding(vertical = 136.dp)
                    .wrapContentHeight(Alignment.Top)
                    .wrapContentWidth(),
                color = textColorSecondary,
                fontSize = 10.sp,
                fontFamily = calibre
            )
        }
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter),

            ) {

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                label = { Text(text = "Email") },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = calibre
                ),
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_email_white_24dp),
                        contentDescription = ""
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedLabelColor = textColorSecondary,
                    unfocusedLabelColor = textColorSecondary,
                    focusedIndicatorColor = textColorSecondary,
                    unfocusedIndicatorColor = textColorSecondary

                )
            )
            TextField(
                value = password.value,
                onValueChange = { str -> password.value = str },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                label = { Text(text = "Password") },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = calibre
                ),
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_lock_white_24dp),
                        contentDescription = ""
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedLabelColor = textColorSecondary,
                    unfocusedLabelColor = textColorSecondary,
                    focusedIndicatorColor = textColorSecondary,
                    unfocusedIndicatorColor = textColorSecondary

                )
            )
            Spacer(modifier = Modifier.size(height = 16.dp, width = 0.dp))
            Row(
                Modifier.align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        onSignInPressed()
                    },
                    Modifier
                        .border(
                            width = 2.dp,
                            color = textColorSecondary,
                            shape = RoundedCornerShape(5.dp)
                        ),
                    shape = RoundedCornerShape(size = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = "Sign up",
                        fontSize = 16.sp,
                        fontFamily = calibre,
                        color = textColorSecondary,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier.size(
                        width = 32.dp,
                        height = 0.dp
                    )
                )
                Button(
                    onClick = {
                        onSignInPressed()
                    },
                    Modifier.border(
                        width = 2.dp,
                        color = textColorSecondary,
                        shape = RoundedCornerShape(5.dp)
                    ),
                    shape = RoundedCornerShape(size = 8.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Text(
                        text = "Sign in",
                        fontSize = 16.sp,
                        fontFamily = calibre,
                        color = textColorSecondary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(
                modifier = Modifier.size(
                    width = 0.dp,
                    height = 24.dp
                )
            )
            Text(
                text = "Forgot password?",
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .align(Alignment.CenterHorizontally),
                color = textColorSecondary,
                fontSize = 16.sp,
                fontFamily = calibre
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    LoginScreen({}, {})
}