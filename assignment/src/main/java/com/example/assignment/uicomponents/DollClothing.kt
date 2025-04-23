package com.example.assignment.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.assignment.R
import com.example.assignment2.model.ClothesData

@Composable
fun DollClothing(
    checkStatesAndClothesList: SnapshotStateList<ClothesData>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box {
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = null,
        )
        checkStatesAndClothesList.forEach { item ->
            val imgR = if (item.checkState) {
                context.resources.getIdentifier(
                    item.clothesName,
                    "drawable",
                    context.packageName
                )
            } else {
                null
            }

            imgR?.let {
                Image(
                    painter = painterResource(id = imgR),
                    contentDescription = null
                )
            }
        }
    }
}