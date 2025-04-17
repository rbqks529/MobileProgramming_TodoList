package com.example.eweek05a.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun FillButtonSample() {
    Button(onClick = {}) { Text("Filled") }
}

@Preview
@Composable
private fun FilledTonalButtonExample() {
    FilledTonalButton(onClick = {}) { Text("Tonal") }
}

@Preview
@Composable
private fun OutlinedButtonExample() {
    OutlinedButton(onClick = {}) { Text("Outlined") }
}


@Composable
private fun ElevatedButtonExample(buttonClick: () -> Unit) {
    ElevatedButton(onClick = buttonClick) { Text("Elevated") }
}

@Preview
@Composable
private fun ElevatedButtonExamplePreview() {
    ElevatedButtonExample {}
}

// 임의로 텍스트 버튼 배경이랑 글자 색 지정 해봄
@Preview(showBackground = true)
@Composable
private fun TextButtonExample() {
    TextButton(
        onClick = {},
        modifier = Modifier.background(Color.Black)
    ) {
        Text(
            text = "Text Button",
            color = Color.White
        )
    }
}

//IconButton
@Composable
fun IconButtonExample(count: Int, modifier: Modifier = Modifier, buttonClick: () -> Unit) {
    IconButton(
        onClick = buttonClick
    ) {
        Icon(
            Icons.Default.Favorite,
            contentDescription = null,
            tint = if(count >= 5) {
                Color.Red
            } else if(count >=3) {
                Color.Green
            } else {
                Color.LightGray
            }
        )
    }
}

@Preview
@Composable
private fun IconButtonExamplePreview() {
    var count by remember { mutableIntStateOf(0) }
    IconButtonExample(count) {
        count++
    }
}

@Preview
@Composable
fun ButtonWithIconSample() {
    Button(
        onClick = { },
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Like")
    }
}
