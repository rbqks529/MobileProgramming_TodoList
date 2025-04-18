package com.example.week06.example02.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.week06.example02.navGraph.LoginNavGraph

@Composable
fun LoginMainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    LoginNavGraph(navController= navController)
}