package com.example.eweek05a.lazyexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextLazyVerticalStaggeredGrid(dataList: List<String>, modifier: Modifier = Modifier) {
    //Cell의 크기가 다른 LazeGrid
    LazyVerticalStaggeredGrid(
        //columns = StaggeredGridCells.Adaptive(100.dp),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        //content는 밖으로 빼도 됨
        items(dataList) { item ->
            //랜덤 크기로 설정
            TextCellRandomSize(text = item, Modifier.background(Color.Green))
        }
    }
}

@Preview
@Composable
private fun TextLazyVerticalStaggeredGridPreview() {
    val dataList = (1..30).map { it.toString() }.toMutableList()
    TextLazyVerticalStaggeredGrid(dataList = dataList, modifier = Modifier.fillMaxSize())
}