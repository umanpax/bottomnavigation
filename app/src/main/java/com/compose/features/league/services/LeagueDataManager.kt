package com.compose.features.league.services

import com.compose.utils.ServiceGenerator
import com.compose.model.Leagues
import retrofit2.Response

class LeagueDataManager(private val serviceGenerator: ServiceGenerator) {

     suspend fun getAllLeagues(): Response<Leagues> {
        val service = serviceGenerator.createServiceLessToken(LeagueService::class.java)
        return service.getAllLeagues()
    }
}

