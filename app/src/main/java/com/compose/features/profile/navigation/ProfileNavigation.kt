package com.compose.features.profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.compose.features.profile.screens.ProfileScreen
import com.compose.navigation.NavigationItem

fun NavGraphBuilder.profileScreen(navigateToHorizontalViewPager: () -> Unit) {
    composable(
        route = NavigationItem.Profile.route,
    ) {
        ProfileScreen(navigateToHorizontalViewPager = navigateToHorizontalViewPager)
    }
}
