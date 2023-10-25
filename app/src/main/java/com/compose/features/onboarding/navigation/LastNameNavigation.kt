package com.compose.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.compose.features.onboarding.screens.LastNameScreen

fun NavGraphBuilder.lastNameScreen(navigateToEnd: () -> Unit) {
    composable(
        route = NavigationOnBoardingItem.LastNameScreen.route,
    ) {
        LastNameScreen(navigateToEnd = navigateToEnd)
    }
}
