package com.compose.features.league.states

import com.compose.model.League

data class LeagueViewState(
    val leagues: List<League> = listOf(),
    val league: League? = null,
    val loading : Boolean = false,
    val showDuplicationDialog : Boolean = false,
    val error : String = ""
)

