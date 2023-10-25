package com.compose.features.team.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.features.team.screens.TeamsScreen
import com.compose.navigation.NavigationItem


internal const val leagueArg = "league"

fun NavGraphBuilder.teamScreen() {
    composable(
        route ="${NavigationItem.Team.route}/{$leagueArg}",
        arguments = listOf(
            navArgument(leagueArg) { type = NavType.StringType },
        )
    ) {
        TeamsScreen()
    }
}
