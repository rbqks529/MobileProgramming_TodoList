package com.example.eweek05a.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageListFactory

class ImageViewModel: ViewModel() {
    private val _imageList = ImageListFactory.makeListImage()
    
    
//    private val _imageList = mutableStateListOf<Item>()   // 빈 리스트 생성 법
//    init {
//        _imageList.addAll(ImageListFactory.makeImageList())
//    }
    
    //밖에서 접근할때 imageList로 접근
    val imageList: MutableList<ImageData>
        get() =_imageList
}