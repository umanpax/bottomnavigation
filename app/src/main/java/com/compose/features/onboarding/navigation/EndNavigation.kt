package com.compose.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.compose.features.onboarding.screens.EndScreen

fun NavGraphBuilder.endScreen() {
    composable(
        route = NavigationOnBoardingItem.EndScreen.route,
    ) {
        EndScreen()
    }
}
