package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eweek04a.R

@Composable
fun TodoListTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .padding(horizontal = 15.dp),
        text = stringResource(R.string.todolist_title),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
private fun TodoListTitlePreview() {
    TodoListTitle()
}

@Composable
fun TodoItem(modifier: Modifier = Modifier) {

}