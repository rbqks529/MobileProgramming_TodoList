package com.example.eweek07a.example01.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eweek07a.example01.model.Routes
import com.example.eweek07a.example01.uicomponents.HomeScreen
import com.example.eweek07a.example01.uicomponents.Screen_A
import com.example.eweek07a.example01.uicomponents.Screen_B
import com.example.eweek07a.example01.uicomponents.Screen_C
import com.example.eweek07a.example01.uicomponents.Screen_D

// NavGraph를 잘 만들어줘야 함
@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // Controller가 이동하기 위한 루트는 NavHost에 선언되어 있어야 함
    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(route = Routes.Home.route) {
            // HomeScreen은 A나 B로 이동가능
            HomeScreen(
                onNavigateA = { navController.navigate(Routes.ScreenA.route) }, // ScreenA로 이동
                onNavigateB = { navController.navigate(Routes.ScreenB.route) }  // ScreenB로 이동
            )
        }

        composable(route = Routes.ScreenA.route) {
            Screen_A(
                onNavigateC = { navController.navigate(Routes.ScreenC.route) }, // ScreenC로 이동하는 함수를 전달
                onNavigateD = { navController.navigate(Routes.ScreenD.route) }
            )
        }

        composable(route = Routes.ScreenB.route) {
            Screen_B()
        }

        composable(route = Routes.ScreenC.route) {
            Screen_C(onNavigate = { navController.navigate(Routes.Home.route) })  // 홈으로 이동
        }

        composable(route = Routes.ScreenD.route) {  // ScreenD를 NavGraph에 선언해야 이동할 수 있음
            Screen_D()
        }
    }
}