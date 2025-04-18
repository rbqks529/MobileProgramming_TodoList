package com.example.week06.example02.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.week06.example02.model.Routes
import com.example.week06.example02.uicomponents.LoginScreen
import com.example.week06.example02.uicomponents.Register
import com.example.week06.example02.uicomponents.WelcomeScreen


@Composable
fun LoginNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Login.route) {

        // 시작 화면 (로그인 화면)
        composable(route = Routes.Login.route) {
            LoginScreen(
                onWelcomeNavigate = { userId ->
                    navController.navigate(
                        Routes.Welcome.route + "/${userId}" // WelcomeScreen의 루트에 userId를 넣어서 이동
                    )
                },
                onRegisterNavigate = { userId, userPassword ->
                    if (userId.isNotEmpty() && userPassword.isNotEmpty())   //ID랑 PW를 둘 다 입력 했을때 값을 넘겨줌
                        navController.navigate(Routes.Register.route + "?userID=${userId}&passWD=${userPassword}")
                    else
                        navController.navigate(Routes.Register.route)   // 기본값으로 쿼리 파라미터 값을 지정
                }
            )
        }

        // 로그인이 성공했을 때의 화면(유저 아이디을 Path Variable로 받음)
        composable(
            route = Routes.Welcome.route + "/{userID}",
            arguments = listOf(navArgument(name = "userID") { type = NavType.StringType }) // argument type 지정
        ) {
            WelcomeScreen(
                it.arguments?.getString("userID")   // nullable 타입으로 선언
            )
        }

        // 로그인에 실패했을때 로그인 할 때 쓴 UserId와 PassWD를 회원가입 페이지에 전달(쿼리 파라미터로)
        composable(
            route = Routes.Register.route + "?userID={userID}&passWD={passWD}",
            arguments = listOf(
                navArgument(name = "userID") {
                    type = NavType.StringType
                    defaultValue = "User"   // 기본값 = "User"
                },
                navArgument(name = "passWD") {
                    type = NavType.StringType
                    defaultValue = ""   // 기본값 = ""
                }
            )
        ) {
            Register(
                it.arguments?.getString("userID"),
                it.arguments?.getString("passWD")
            )
        }
    }
}