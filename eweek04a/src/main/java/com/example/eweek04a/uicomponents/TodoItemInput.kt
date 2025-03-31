package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    var textFieldState by remember { mutableStateOf("") }
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = textFieldState,
            /*onValueChange = {text:String -> textFieldState = text}*/
            onValueChange = {textFieldState = it},
            placeholder = { Text("할 일을 입력하세요.") }
        )
        Button(
            // TODO: 눌렀을 때 리스트에 추가하는 거 완성하기 (시간정보 생성해서 아이템 만들고 리스트 추가)
            onClick = {
                val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
                todoList.add(Item(textFieldState, currentTime))
                textFieldState = ""
            }
        ) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}