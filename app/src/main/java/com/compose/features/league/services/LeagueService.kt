package com.compose.features.league.services

import com.compose.model.Leagues
import retrofit2.Response
import retrofit2.http.*

interface LeagueService {

    /**
     * Get All Leagues
     * @return
     */
    @GET("api/v1/json/50130162/all_leagues.php")
    suspend fun getAllLeagues(): Response<Leagues>

}

