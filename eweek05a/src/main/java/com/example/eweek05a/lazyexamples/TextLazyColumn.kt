package com.example.eweek05a.lazyexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextLazyColumn(dataList: MutableList<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        //content가 사이드에서 안 잘림
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = dataList) {item->
            TextCell(text = item, Modifier.background(Color.Cyan))
        }
    }
}

@Preview
@Composable
private fun TextLazyColumnBasicPreview() {
    // .map 을 통해서 String으로 바꾸고 MutableList로 병경
    val dataList = (1..20).map { it.toString() }.toMutableList()
    TextLazyColumn(dataList = dataList, modifier = Modifier.fillMaxSize())
}

