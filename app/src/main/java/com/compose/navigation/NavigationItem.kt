package com.compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    object League : NavigationItem("League", Icons.Rounded.List, "League")
    object Profile : NavigationItem("Profile", Icons.Rounded.Info, "Profile")
    object Team : NavigationItem("Team", Icons.Rounded.Info, "Team")
}
