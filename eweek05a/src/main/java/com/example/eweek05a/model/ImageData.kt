package com.example.eweek05a.model

import androidx.compose.runtime.saveable.listSaver

// state로 사용할 객체 -> 기본 데이터 타입으로 되어 있지 않기에 직렬화 객체를 사용 하지 못 함
data class ImageData(
    val image: ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    var likes: Int = 0,
    var dislikes: Int = 0
) {
    companion object {
        // 저장할 때는 리스트로 펼쳐서 ImageData를 저장
        val imageSaver = listSaver<ImageData, Any>(
            save = { item ->
                listOf(
                    // when과 is를 통해서 이미지의 Uri가 Int인지 String인지 알아냄
                    when (item.image) {
                        is ImageUri.ResImage -> item.image.resID
                        is ImageUri.WebImage -> item.image.webUrl
                    },
                    // 열거체는 name을 통해서 저장 가능
                    item.buttonType.name,
                    item.likes,
                    item.dislikes
                )
            },
            // 리스트로 저장한 것을 그대로 다시 ImageData로 만들어 줌
            restore = { list ->
                val img = list[0]
                val image = when(img) {
                    is Int -> ImageUri.ResImage(img)
                    is String -> ImageUri.WebImage(img)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                ImageData(
                    image = image,
                    buttonType = ButtonType.valueOf(list[1] as String),
                    likes = list[2] as Int,
                    dislikes = list[3] as Int
                )
            }
        )
    }
}