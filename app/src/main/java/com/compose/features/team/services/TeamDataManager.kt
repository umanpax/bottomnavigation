package com.compose.features.team.services

import com.compose.utils.ServiceGenerator
import com.compose.model.Teams
import retrofit2.Response


class TeamDataManager(private val serviceGenerator: ServiceGenerator) {

     suspend fun getAllTeams(lang: String): Response<Teams> {
        val service = serviceGenerator.createServiceLessToken(TeamService::class.java)
        return service.getAllTeams(lang)
    }
}

