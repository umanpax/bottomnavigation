package com.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.compose.features.league.navigation.leagueScreen
import com.compose.features.profile.navigation.profileScreen
import com.compose.features.team.navigation.teamScreen


@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController, startDestination = NavigationItem.League.route) {
        leagueScreen(navigateToTeam = { data ->
            val route ="${NavigationItem.Team.route}/$data"
            navController.navigate(route)
        })
        profileScreen()
        teamScreen()
    }
}

