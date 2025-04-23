package com.example.assignment.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment2.model.ClothesData


@Composable
fun LandscapeScreen(
    checkStatesAndClothesList: SnapshotStateList<ClothesData>,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "202012362 조규빈")
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(width = 100.dp))
            DollClothing(checkStatesAndClothesList)
            TwoComponentCheckBox(checkStatesAndClothesList)
            Spacer(modifier = Modifier.width(width = 100.dp))
        }
    }
}

@Preview
@Composable
private fun LandscapeScreenPreview() {
    val checkStatesAndClothesList = rememberSaveable(saver = ClothesData.ClothesDataListSaver) {
        mutableStateListOf<ClothesData>(
            ClothesData(false, "arms"),
            ClothesData(false, "ears"),
            ClothesData(false, "eyebrows"),
            ClothesData(false, "eyes"),
            ClothesData(false, "glasses"),
            ClothesData(false, "hat"),
            ClothesData(false, "mouth"),
            ClothesData(false, "mustache"),
            ClothesData(false, "nose"),
            ClothesData(false, "shoes")
        )
    }

    LandscapeScreen(checkStatesAndClothesList)
}