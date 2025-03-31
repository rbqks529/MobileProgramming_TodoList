package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.TodoItemFactory


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        //mutableStateListOf<Item>()  -> 빈 리스트
        TodoItemFactory.makeTodoList()
    }
    var switchState by remember { mutableStateOf(false) }
    val onCheckedChange = { isChecked: Boolean ->
        switchState = isChecked
    }

    Column(modifier = modifier) {
        TodoListTitle()

        // TODO: 스위치도 넣어야 됨
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(vertical = 15.dp)
                .fillMaxWidth(),
        ) {
            Text(text = "미완료 항목만 보기")
            Spacer(modifier = Modifier.width(10.dp))
            TodoListSwitch(switchState) { onCheckedChange(it) }
        }

        TodoList(todoList, switchState, Modifier.weight(1f))
        TodoItemInput(todoList)
    }
}