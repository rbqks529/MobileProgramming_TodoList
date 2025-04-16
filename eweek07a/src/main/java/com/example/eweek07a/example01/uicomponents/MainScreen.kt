package com.example.eweek07a.example01.uicomponents

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.eweek07a.example01.navGraph.NavGraph

@SuppressLint("RestrictedApi")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    navController.addOnDestinationChangedListener {_, _, _, ->
        navController.currentBackStack.value.forEachIndexed { index, navBackStackEntry ->
            Log.d("BackStack", "$index ${navBackStackEntry.destination.route}")
        }
    }
    NavGraph(navController = navController) // StartDestination이 Home이었기에 Home에서 시작
}