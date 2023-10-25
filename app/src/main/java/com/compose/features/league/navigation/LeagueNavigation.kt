package com.compose.features.league.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.compose.features.league.screens.LeaguesScreen
import com.compose.navigation.NavigationItem

fun NavGraphBuilder.leagueScreen(navigateToTeam: (data : String) -> Unit) {
    composable(
        route = NavigationItem.League.route,
    ) {
        LeaguesScreen(navigateToTeam = navigateToTeam)
    }
}
