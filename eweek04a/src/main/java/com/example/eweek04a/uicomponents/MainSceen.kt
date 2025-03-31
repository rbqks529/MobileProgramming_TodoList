package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember { 
        //mutableStateListOf(<item>()  -> 빈 리스트
        TodoItemFactory.makeTodoList()
    }
    Column { 
        TodoListTitle()
        // TODO: 스위치도 넣어야 됨 
        TodoList(todoList)
        TodoItemInput(todoList)
    }
}