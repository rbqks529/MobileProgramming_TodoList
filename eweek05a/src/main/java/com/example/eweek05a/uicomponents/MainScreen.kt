package com.example.eweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eweek05a.lazyexamples.ScrollToTopButton
import com.example.eweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    //val imageViewModel: ImageViewModel = viewModel()

    // 동일한 viewModel 객체를 사용하게 됨
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation
    val state: LazyListState = rememberLazyListState()
    val scope: CoroutineScope = rememberCoroutineScope()

    val showButton by remember {
        // 다른 state(firstVisibleItemIndex)에 따라서 값이 변경됨 -> 효율적임
        derivedStateOf {
            // top에 있는 content의 인덱스가 firstVisibleItemIndex
            state.firstVisibleItemIndex > 0
        }
    }

    Box (modifier = Modifier.fillMaxSize()) {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                state = state,  //state를 인자로 줌
                contentPadding = PaddingValues(vertical = 50.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                itemsIndexed(items = imageList) { index, item ->
                    ImageListData(index = index, imageData = item, imageList = imageList)
                }
            }
            AnimatedVisibility(visible = showButton) {
                ScrollToTopButton {
                    // 인자로 함수를 FAB에 전달
                    scope.launch {
                        state.animateScrollToItem(0) // scrollToItem도 suspend fun임
                    }
                }
            }
        } else {
            LazyRow(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                state = state,  //state를 인자로 줌
                contentPadding = PaddingValues(horizontal = 50.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                itemsIndexed(items = imageList) { index, item ->
                    ImageListData(index = index, imageData = item, imageList = imageList)
                }
            }
        }
    }

//    var img1State by rememberSaveable(
//        stateSaver = ImageData.imageSaver
//    ) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.BADGE,
//                likes = 50
//            )
//        )
//    }
//
//    var img2State by rememberSaveable(
//        stateSaver = ImageData.imageSaver
//    ) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 30,
//                dislikes = 10
//            )
//        )
//    }
//
//    Column {
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                //img1State.likes++ 이런식으로 일부 속성만 바꾸면 변경을 감지하지 못함
//                img1State = img1State.copy(
//                    likes = img1State.likes + 1
//                )
//            }
//        }
//
//        ImageWithButton(img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(
//                        likes = img2State.likes + 1
//                    )
//                }
//            ) {
//                img2State = img2State.copy(
//                    dislikes = img2State.dislikes + 1
//                )
//            }
//        }
//    }


}
