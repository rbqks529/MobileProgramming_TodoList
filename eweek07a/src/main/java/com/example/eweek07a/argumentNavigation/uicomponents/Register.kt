package com.example.eweek07a.argumentNavigation.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp

@Composable
fun Register(
    userID: String?,
    userPasswd: String?
) {
    // 전달받은 ID를 State로 지정
    var userIdState by remember {
        mutableStateOf(userID ?: "")
    }
    // 전달받은 PW를 State로 지정
    var userPasswdState by remember {
        mutableStateOf(userPasswd ?: "")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Register Screen",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            // 사용자에게 입력 받은 UserID를 띄움
            text = "${userID}, let's start the registration process.",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )
        
        // 사용자의 Id를 가져옴
        OutlinedTextField(
            value = userIdState,
            onValueChange = { userIdState = it },
            label = { Text("User ID") }
        )
        
        // 사용자의 PW를 가져옴
        OutlinedTextField(
            value = userPasswdState,
            onValueChange = { userPasswdState = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}