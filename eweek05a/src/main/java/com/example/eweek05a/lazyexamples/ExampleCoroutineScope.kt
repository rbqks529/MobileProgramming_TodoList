package com.example.eweek05a.lazyexamples

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun RandomColorButton() {
    // 코루틴 스코프 객체 (Composable 함수 내의 특정 이벤트 안에서만 실행 가능)
    val scope = rememberCoroutineScope()
    // Color는 기본이 빨강
    var color by remember { mutableStateOf(Color.Red) }
    
    Column {
        Button(
            onClick = {
                scope.launch {
                    // 버튼을 누르면 난수 발생을 통해 색상 변경
                    while (true) {
                        // 색이 너무 빨리 변하기에 delay함수(suspend fun)를 사용
                        delay(500)
                        color = Color(
                            Random.nextInt(0xFF),   //R
                            Random.nextInt(0xFF),   //G
                            Random.nextInt(0xFF),   //B
                            0xFF
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text("Change Color")
        }
    }
}

@Composable
fun RandomColorButton2() {
    val scope = rememberCoroutineScope()
    var color by remember { mutableStateOf(Color.Red) }

    Column {
        Button(
            // 코루틴을 두 개 생성
            onClick = {
                // job을 받아서 저장
               val job = scope.launch {
                    while (true) {
                        delay(500)
                        color = Color(
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            Random.nextInt(0xFF),
                            0xFF
                        )
                    }
                }

                // 2초 후에 위에서 진행 중인 코루틴 작업을 취소 (2초 동안만 색상이 변경됨)
                scope.launch {
                    delay(2000)
                    job.cancel()
                }
            },
            colors = ButtonDefaults.buttonColors(color)
        ) {
            Text("Change Color")
        }
    }
}

@Preview
@Composable
private fun RandomColorButtonPreview() {
    Column {
        RandomColorButton()
        RandomColorButton2()
    }

}