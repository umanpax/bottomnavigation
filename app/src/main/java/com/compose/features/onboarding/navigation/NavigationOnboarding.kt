package com.compose.features.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavigationOnBoarding(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationOnBoardingItem.FirstNameScreen.route) {
        firstNameScreen(navigateToLastName = {
            val route = NavigationOnBoardingItem.LastNameScreen.route
            navController.navigate(route)
        })
        lastNameScreen(navigateToEnd = {
            val route = NavigationOnBoardingItem.EndScreen.route
            navController.navigate(route)
        })

        endScreen()
    }

}

