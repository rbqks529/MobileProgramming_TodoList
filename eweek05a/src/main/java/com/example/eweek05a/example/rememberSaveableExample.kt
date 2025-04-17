package com.example.eweek05a.example

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek05a.R
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.model.ImageUri
import com.example.eweek05a.uicomponents.ButtonWithBadge
import com.example.eweek05a.uicomponents.ButtonWithEmoji
import com.example.eweek05a.uicomponents.ImageWithButton

@Composable
fun rememberSavableExample(modifier: Modifier = Modifier) {
        var img1State by rememberSaveable(
        stateSaver = ImageData.imageSaver
    ) {
        mutableStateOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img1),
                buttonType = ButtonType.BADGE,
                likes = 50
            )
        )
    }

    var img2State by rememberSaveable(
        stateSaver = ImageData.imageSaver
    ) {
        mutableStateOf(
            ImageData(
                image = ImageUri.ResImage(R.drawable.img2),
                buttonType = ButtonType.EMOJI,
                likes = 30,
                dislikes = 10
            )
        )
    }

    Column {
        ImageWithButton(image = img1State.image) {
            ButtonWithBadge(likes = img1State.likes) {
                //img1State.likes++ 이런식으로 일부 속성만 바꾸면 변경을 감지하지 못함
                img1State = img1State.copy(
                    likes = img1State.likes + 1
                )
            }
        }

        ImageWithButton(img2State.image) {
            ButtonWithEmoji(
                likes = img2State.likes,
                dislikes = img2State.dislikes,
                onClickLikes = {
                    img2State = img2State.copy(
                        likes = img2State.likes + 1
                    )
                }
            ) {
                img2State = img2State.copy(
                    dislikes = img2State.dislikes + 1
                )
            }
        }
    }
}

@Preview
@Composable
private fun rememberSavableExamplePreview() {
    rememberSavableExample()
}