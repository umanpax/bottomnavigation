package com.compose.features.onboarding.navigation

sealed class NavigationOnBoardingItem(var route: String, var title: String) {

    object FirstNameScreen : NavigationOnBoardingItem("FirstNameScreen", "FirstName")
    object LastNameScreen : NavigationOnBoardingItem("LastNameScreen", "LastName")
    object EndScreen : NavigationOnBoardingItem("EndScreen", "End")
}
