package com.example.week06.example02.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
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
fun LoginScreen(onWelcomeNavigate: (String) -> Unit, onRegisterNavigate: (String, String) -> Unit) {

    val userId = "greenjoa"
    val userPasswd = "1234"

    var userIdState by remember {   //ID 입력 TextField의 State
        mutableStateOf("")
    }

    var userPasswdState by remember {   //PW 입력 TextField의 State
        mutableStateOf("")
    }

    // 사용자가 입력한 상태에 따라서 정해짐(로그인 성공 여부)
    val loginresult by remember {
        derivedStateOf { userId == userIdState && userPasswd == userPasswdState }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login Screen",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        OutlinedTextField(
            value = userIdState,
            onValueChange = { userIdState = it },
            label = { Text("User ID") }
        )
        
        // 비밀번호 입력창
        OutlinedTextField(
            value = userPasswdState,
            onValueChange = { userPasswdState = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),  // 입력하면 패스워트 처럼 ***로 입력
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) // 키보드 옵션으로 키보드 타입으로 패스워드 용도로 지정 (소프트 키보드)
        )

        Button(onClick = {
            if(loginresult) {
                // 성공하면 로그인 (유저 아이디만 전달)
                onWelcomeNavigate(userIdState)
            } else {
                // 실패하면 회원가입 (유저 아이디와 PW 둘 다 전달)
                onRegisterNavigate(userIdState, userPasswdState)
            }
        }) {
            Text(text = "Login")
        }
    }
}