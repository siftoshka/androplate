package com.androplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.androplate.auth.login.navigation.loginScreen
import com.androplate.auth.login.navigation.navigateToLogin
import com.androplate.auth.onboarding.navigation.ONBOARDING_ROUTE
import com.androplate.auth.onboarding.navigation.onboardingScreen
import com.androplate.home.browse.navigation.browseScreen
import com.androplate.home.browse.navigation.navigateToBrowse

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ONBOARDING_ROUTE
    ) {
        onboardingScreen(onLoginClick = navController::navigateToLogin)
        loginScreen(
            onBack = navController::navigateUp,
            onNavHome = navController::navigateToBrowse
        )
        browseScreen()
    }
}