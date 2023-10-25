package com.compose.features.league.services

import com.compose.model.Leagues
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LeagueRepository(private val dataManager: LeagueDataManager) {

    fun getAllLeagues(): Flow<Leagues> = flow {
        val response = dataManager.getAllLeagues()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it)
            }
        } else {
            error(response.errorBody().toString())
        }
    }
}
