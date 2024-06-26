package com.androplate.auth.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.androplate.auth.login.LoginScreen

const val LOGIN_ROUTE = "login"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) = navigate(LOGIN_ROUTE, navOptions)

fun NavGraphBuilder.loginScreen(
    onBack: () -> Unit,
    onNavHome: () -> Unit,
) {
    composable(route = LOGIN_ROUTE) {
        LoginScreen(onBack = onBack, onNavHome = onNavHome)
    }
}