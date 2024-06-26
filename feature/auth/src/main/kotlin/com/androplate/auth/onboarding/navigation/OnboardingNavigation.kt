package com.androplate.auth.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.androplate.auth.onboarding.OnboardingScreen

const val ONBOARDING_ROUTE = "onboarding"

fun NavGraphBuilder.onboardingScreen(
    onLoginClick: () -> Unit
) {
    composable(route = ONBOARDING_ROUTE) {
        OnboardingScreen(onLoginClick = onLoginClick)
    }
}