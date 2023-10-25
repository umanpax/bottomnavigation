package com.compose.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class League(
    @SerializedName("idLeague")
    @Expose
    val idLeague: String,
    @SerializedName("strLeague")
    @Expose
    var strLeague: String,
    @SerializedName("strSport")
    @Expose
    val strSport: String,
    @SerializedName("strLeagueAlternate")
    @Expose
    val strLeagueAlternate: String,

    var canBeDuplicate: Boolean = true
) : Serializable
