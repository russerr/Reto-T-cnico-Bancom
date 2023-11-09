package com.russerdev.core.navigation

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.russerdev.presentation.login.LoginScreen
import com.russerdev.presentation.login.LoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

fun NavGraphBuilder.loginGraph(
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
                onNextScreen =  {  }
            )
        }
    }
}