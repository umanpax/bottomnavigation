package com.compose.utils

import com.compose.model.Leagues
import com.compose.model.Teams

sealed class Result {
    data class TeamResult(val teams: Teams) : Result()
    data class LeagueResult(val leagues: Leagues) : Result()
    data class ErrorResult(val message: String) : Result()
}
