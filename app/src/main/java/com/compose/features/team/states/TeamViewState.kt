package com.compose.features.team.states

import com.compose.model.Team

data class TeamViewState(
    val teams: List<Team> = listOf(),
    val error: String = "",
)

