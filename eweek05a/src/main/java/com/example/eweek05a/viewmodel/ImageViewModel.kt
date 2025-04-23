package com.example.eweek05a.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageListFactory

class ImageViewModel : ViewModel() {
    private val _imageList = mutableStateListOf<ImageData>().apply {
        addAll(ImageListFactory.makeListImage())
    }

    // 외부에 노출
    val imageList: MutableList<ImageData>
        get() = _imageList

    // 좋아요 증가
    fun incrementLikes(index: Int) {
        _imageList[index] = _imageList[index].copy(
            likes = _imageList[index].likes + 1
        )
    }

    // 싫어요 증가
    fun incrementDislikes(index: Int) {
        _imageList[index] = _imageList[index].copy(
            dislikes = _imageList[index].dislikes + 1
        )
    }
}

// 작년 중간구사 네비게이션 만들 때 view모델을 넘기는 방식 말고 다른 방식으로 만들어보기