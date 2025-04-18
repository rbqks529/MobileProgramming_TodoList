package com.example.eweek07a.basicNavigation.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// 인자로 람다 함수 두 개를 인자로 받음 (NavGraph에서 전달)
@Composable
fun HomeScreen(onNavigateA: () -> Unit, onNavigateB: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Button(onClick = {
            onNavigateA()   // A로 이동
        }) {
            Text(text = "Screen A")
        }

        Button(onClick = onNavigateB   // B로 이동
        ) {
            Text(text = "Screen B")
        }
    }
}
