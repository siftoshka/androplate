package com.androplate.home.browse.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.androplate.home.browse.BrowseScreen

const val BROWSE_ROUTE = "nav_browse"

fun NavController.navigateToBrowse(navOptions: NavOptions? = null) = navigate(BROWSE_ROUTE, navOptions)

fun NavGraphBuilder.browseScreen() {
    composable(route = BROWSE_ROUTE) {
        BrowseScreen()
    }
}