package com.example.eweek04a.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
//람다 함수는 마지막 인자일 때 함수 괄호 밖에 기술 가능
fun TodoCheckbox(
    checked: Boolean,
    modifier: Modifier = Modifier
) {
    Checkbox(
        checked = checked,
        //checkbox와 관련된 데이터는 리스트에 있음
        onCheckedChange = null
        //onCheckedChange = {onCheckedChange(it)}
    )
}