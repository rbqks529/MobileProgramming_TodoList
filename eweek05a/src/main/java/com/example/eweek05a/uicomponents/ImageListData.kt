package com.example.eweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData

@Composable
fun ImageListData(
    modifier: Modifier = Modifier,
    index: Int,
    imageData: ImageData,
    imageList: MutableList<ImageData>
) {
    when (imageData.buttonType) {
        ButtonType.ICON -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithIcon(likes = imageData.likes) {
                    //img1State.likes++ 이런식으로 일부 속성만 바꾸면 변경을 감지하지 못함
                    imageList[index] = imageData.copy(
                        likes = imageData.likes + 1
                    )
                }
            }
        }

        ButtonType.BADGE -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithBadge(likes = imageData.likes) {
                    //img1State.likes++ 이런식으로 일부 속성만 바꾸면 변경을 감지하지 못함
                    imageList[index] = imageData.copy(
                        likes = imageData.likes + 1
                    )
                }
            }
        }

        ButtonType.EMOJI -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithEmoji(
                    likes = imageData.likes,
                    dislikes = imageData.dislikes,
                    onClickLikes = {
                        imageList[index] = imageData.copy(
                            likes = imageData.likes + 1
                        )
                    },
                    onClickDisLikes = {
                        imageList[index] = imageData.copy(
                            dislikes = imageData.dislikes + 1
                        )
                    }
                )
            }
        }
    }
}