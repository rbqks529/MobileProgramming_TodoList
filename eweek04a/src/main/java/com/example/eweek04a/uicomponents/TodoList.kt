package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth() //가로로 가득 차게
            .verticalScroll(scrollState)    //세로로 스크롤 가능
    ) {
        //인자가 두개이기에 생략 불가 & it으로 가져오기 불가
        todoList.forEachIndexed { index, item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Row {
                    // TODO: 아직은 체크 상태 변경이 감지되지 않음 -> 리스트를 State로 사용해서 해결 못함
                    // 리스트 안의 아이템의 일부 속성의 변경은 감지 못함 -> item을 새로 생성해서 넣어주면 됨
                    TodoCheckbox(checked = item.status == TodoStatus.COMPLETED) { ischecked ->
                        todoList[index] =
                            item.copy(
                                status = if (ischecked) TodoStatus.COMPLETED
                                else TodoStatus.PENDING
                            )
                    }
                    TodoItem(item = item)
                }

            }
        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList())
}