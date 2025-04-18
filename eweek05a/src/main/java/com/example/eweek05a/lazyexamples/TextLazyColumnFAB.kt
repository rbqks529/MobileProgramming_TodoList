package com.example.eweek05a.lazyexamples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TextLazyColumnFAB(dataList: MutableList<String>, modifier: Modifier = Modifier) {
    val state = rememberLazyListState() // LazyColumn의 스크롤 위치를 이동 하기 위한 state
    val scope = rememberCoroutineScope()  // 코루틴 스코프 객체를 생성

    val showButton by remember {
        // 다른 state(firstVisibleItemIndex)에 따라서 값이 변경됨 -> 효율적임
        derivedStateOf {
            // top에 있는 content의 인덱스가 firstVisibleItemIndex
            // Compose는 의존된 값(state.firstVisibleItemIndex) 가 정말로 바뀌었을 때만 recomposition을 트리거 함
            state.firstVisibleItemIndex > 0
        }
    }

    // Box의 제일 위에 FAB를 배치 하면됨 (제일 마지막에 선언)
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = state,  //state를 인자로 줌
            modifier = modifier,
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = dataList) {item->
                TextCell(text = item, Modifier.background(Color.Green))
            }
        }
        // showButton이라는 상태에 따라서 FAB가 보이고 안보이고 할 수 있음
        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton {
                // 인자로 함수를 FAB에 전달
                scope.launch {
                    state.scrollToItem(0) // scrollToItem도 suspend fun임
                }
            }
        }
    }
}

@Preview
@Composable
private fun TextLazyColumnFABPreview() {
    val dataList = (1..15).map { it.toString() }.toMutableList()
    TextLazyColumnFAB(dataList = dataList, modifier = Modifier.fillMaxSize())
}