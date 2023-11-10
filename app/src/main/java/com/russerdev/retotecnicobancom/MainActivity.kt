package com.russerdev.retotecnicobancom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.russerdev.core.navigation.loginGraph
import com.russerdev.retotecnicobancom.ui.theme.RetoTecnicoBancomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoTecnicoBancomTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "/Onboarding_Module") {
                    loginGraph(navController)
                }
            }
        }
    }
}