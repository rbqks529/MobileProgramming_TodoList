package com.example.assignment2.model

import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList

data class ClothesData(val checkState: Boolean, val clothesName: String) {
    companion object {
        val ClothesDataListSaver = listSaver<SnapshotStateList<ClothesData>, Any>(
            save = { list ->
                // 리스트안에 리스트를 펼쳐서 저장
                list.flatMap { clothes ->
                    listOf<Any>(
                        clothes.checkState, clothes.clothesName
                    )
                }
            },
            restore = { flat ->
                // restore 할때는 묶어야 하기에 chunked를 사용
                flat.chunked(2).map { (checkState, clothesName) ->
                    ClothesData(
                        checkState as Boolean, clothesName as String
                    )
                }.toMutableStateList()
            }
        )
    }
}
