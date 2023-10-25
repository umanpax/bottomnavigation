package com.compose.features.team.services

import com.compose.model.Teams
import retrofit2.Response
import retrofit2.http.*

interface TeamService {

    /**
     * Get All Teams
     * @return
     */
    @GET("api/v1/json/50130162/search_all_teams.php")
    suspend fun getAllTeams(@Query("l") league: String): Response<Teams>

}

