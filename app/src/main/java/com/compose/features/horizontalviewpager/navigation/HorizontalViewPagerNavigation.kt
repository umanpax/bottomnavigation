package com.compose.features.horizontalviewpager.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.compose.features.horizontalviewpager.screens.HorizontalViewPagerScreen
import com.compose.navigation.NavigationItem


fun NavGraphBuilder.horizontalViewPagerScreen() {
    composable(
        route = NavigationItem.HorizontalViewPager.route,
    ) {
        HorizontalViewPagerScreen()
    }
}
