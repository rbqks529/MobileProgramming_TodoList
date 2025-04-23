package com.example.eweek07a.argumentNavigation.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.eweek07a.argumentNavigation.navGraph.LoginNavGraph

@Composable
fun LoginMainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    LoginNavGraph(navController= navController)
}