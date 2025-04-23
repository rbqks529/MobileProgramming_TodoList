package com.example.assignment.uicomponents

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.model.ClothesData


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
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
    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        PortraitScreen(checkStatesAndClothesList, modifier)
    } else {
        LandscapeScreen(checkStatesAndClothesList, modifier)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}