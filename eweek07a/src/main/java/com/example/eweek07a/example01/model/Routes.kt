package com.example.eweek07a.example01.model

// 경로 문자열을 생성
sealed class Routes(val route: String) {
    object Home : Routes(route = "Home")
    object ScreenA : Routes(route = "A")
    object ScreenB : Routes(route = "B")
    object ScreenC : Routes(route = "C")
    object ScreenD : Routes(route = "D")
}