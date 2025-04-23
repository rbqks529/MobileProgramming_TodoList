package com.example.assignment.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
fun TwoComponentCheckBox(
    checkStatesAndClothesList: SnapshotStateList<ClothesData>,
    modifier: Modifier = Modifier
) {
    Column(
    ) {
        checkStatesAndClothesList.chunked(2).forEachIndexed { indexes, items ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                items.forEachIndexed { index, item ->
                    val realIndex = indexes * 2 + index

                    ImageNameWithCheckBox(
                        checked = checkStatesAndClothesList[realIndex].checkState,
                        clothes = item.clothesName
                    ) { newChecked ->
                        checkStatesAndClothesList[realIndex] =
                            item.copy(checkState = newChecked)
                    }
                }
            }
        }
    }
}


// lazyGrid로 표시하는 방법
@Composable
fun TwoComponentCheckBoxGrid(
    checkStatesAndClothesList: SnapshotStateList<ClothesData>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.size(300.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        itemsIndexed(checkStatesAndClothesList) { index, item ->
            ImageNameWithCheckBox(
                checked = item.checkState,
                clothes = item.clothesName
            ) { newChecked ->
                checkStatesAndClothesList[index] =
                    item.copy(checkState = newChecked)
            }
        }
    }
}

@Preview
@Composable
private fun TwoComponentCheckBoxPreview() {
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

    TwoComponentCheckBox(checkStatesAndClothesList)
}

@Preview
@Composable
private fun TwoComponentCheckBoxGridPreview() {
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

    TwoComponentCheckBoxGrid(checkStatesAndClothesList)
}