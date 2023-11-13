package com.russerdev.retotecnicobancom.navigation

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.russerdev.presentation.home.HomeScreen
import com.russerdev.presentation.login.LoginScreen
import com.russerdev.presentation.login.LoginViewModel

fun NavGraphBuilder.onboardingModuleGraph(
    navController: NavController
) {
    navigation(
        route = "/Onboarding_Module",
        startDestination = "/login"
    ) {
        composable(
            route = "/login"
        ) {

            val viewModel: LoginViewModel = hiltViewModel()

            LoginScreen(
                state = viewModel.screenState.collectAsState().value,
                uiEvent = viewModel.uiEvent,
                onEvent = viewModel::onEvent,
                onNextScreen = {
                    navController.navigate("/Home_Module") {
                        popUpTo("/Onboarding_Module") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

fun NavGraphBuilder.homeModuleGraph(
    navController: NavController
) {
    navigation(
        route = "/Home_Module",
        startDestination = "/home"
    ) {
        composable(
            route = "/home"
        ) {

        }
    }
}