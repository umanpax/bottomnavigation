package com.compose.features.team.services

import com.compose.model.Teams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TeamRepository(private val dataManager: TeamDataManager) {

    fun getAllTeams(league: String): Flow<Teams> = flow {
        val response = dataManager.getAllTeams(league)
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it)
            }
        } else {
            error(response.errorBody().toString())
        }
    }
}

