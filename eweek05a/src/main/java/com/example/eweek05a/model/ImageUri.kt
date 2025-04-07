package com.example.eweek05a.model

// 자식 클래스가 생성되는 범위를 제한
sealed class ImageUri {
    data class ResImage(val resID: Int) : ImageUri()
    data class WebImage(val webUrl: String) : ImageUri()
}