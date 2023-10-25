package com.compose.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.compose.features.main.viewmodels.MainScreenViewModel
import com.compose.features.onboarding.screens.FirstNameScreen

fun NavGraphBuilder.firstNameScreen(navigateToLastName: () -> Unit) {
    composable(
        route = NavigationOnBoardingItem.FirstNameScreen.route,
    ) {
        FirstNameScreen(navigateToLastName = navigateToLastName)
    }
}
