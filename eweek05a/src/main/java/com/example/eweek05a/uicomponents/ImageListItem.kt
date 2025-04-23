package com.example.eweek05a.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.model.ButtonType
import com.example.eweek05a.model.ImageData
import com.example.eweek05a.viewmodel.ImageViewModel


// LazyList를 사용할 때 사용한 함수
@Composable
fun ImageListItem(
    modifier: Modifier = Modifier,
    index: Int,
    imageData: ImageData,
    imageViewModel: ImageViewModel = viewModel()
) {
    val onLike = { imageViewModel.incrementLikes(index) }
    val onDislike = { imageViewModel.incrementDislikes(index) }

    when (imageData.buttonType) {
        ButtonType.ICON -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithIcon(
                    likes = imageData.likes,
                    onClick = onLike
                )
            }
        }

        ButtonType.BADGE -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithBadge(
                    likes = imageData.likes,
                    onClick = onLike
                )

            }
        }

        ButtonType.EMOJI -> {
            ImageWithButton(image = imageData.image) {
                ButtonWithEmoji(
                    likes = imageData.likes,
                    dislikes = imageData.dislikes,
                    onClickLikes = onLike,
                    onClickDisLikes = onDislike
                )
            }
        }
    }
}