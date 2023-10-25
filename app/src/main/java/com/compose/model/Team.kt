package com.compose.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team(
    @SerializedName("idTeam")
    @Expose
    val idTeam: String,

    @SerializedName("idSoccerXML")
    @Expose
    val idSoccerXML: String,

    @SerializedName("idAPIfootball")
    @Expose
    val idAPIfootball: String,

    @SerializedName("intLoved")
    @Expose
    val intLoved: String?,

    @SerializedName("strTeam")
    @Expose
    val strTeam: String,

    @SerializedName("strTeamShort")
    @Expose
    val strTeamShort: String?,

    @SerializedName("strAlternate")
    @Expose
    val strAlternate: String,

    @SerializedName("intFormedYear")
    @Expose
    val intFormedYear: String,

    @SerializedName("strSport")
    @Expose
    val strSport: String,

    @SerializedName("strLeague")
    @Expose
    val strLeague: String,

    @SerializedName("idLeague")
    @Expose
    val idLeague: String,

    @SerializedName("strLeague2")
    @Expose
    val strLeague2: String,

    @SerializedName("idLeague2")
    @Expose
    val idLeague2: String,

    @SerializedName("strLeague3")
    @Expose
    val strLeague3: String?,

    @SerializedName("idLeague3")
    @Expose
    val idLeague3: String?,

    @SerializedName("strLeague4")
    @Expose
    val strLeague4: String?,

    @SerializedName("idLeague4")
    @Expose
    val idLeague4: String?,

    @SerializedName("strLeague5")
    @Expose
    val strLeague5: String?,

    @SerializedName("idLeague5")
    @Expose
    val idLeague5: String?,

    @SerializedName("strLeague6")
    @Expose
    val strLeague6: String?,

    @SerializedName("idLeague6")
    @Expose
    val idLeague6: String?,

    @SerializedName("strLeague7")
    @Expose
    val strLeague7: String?,

    @SerializedName("idLeague7")
    @Expose
    val idLeague7: String?,

    @SerializedName("strDivision")
    @Expose
    val strDivision: String?,

    @SerializedName("strStadium")
    @Expose
    val strStadium: String,

    @SerializedName("strKeywords")
    @Expose
    val strKeywords: String,

    @SerializedName("strRSS")
    @Expose
    val strRSS: String,

    @SerializedName("strStadiumThumb")
    @Expose
    val strStadiumThumb: String,

    @SerializedName("strStadiumDescription")
    @Expose
    val strStadiumDescription: String,

    @SerializedName("strStadiumLocation")
    @Expose
    val strStadiumLocation: String,

    @SerializedName("intStadiumCapacity")
    @Expose
    val intStadiumCapacity: String,

    @SerializedName("strWebsite")
    @Expose
    val strWebsite: String,

    @SerializedName("strFacebook")
    @Expose
    val strFacebook: String,

    @SerializedName("strTwitter")
    @Expose
    val strTwitter: String,
    @SerializedName("strInstagram")
    @Expose
    val strInstagram: String?,

    @SerializedName("strDescriptionEN")
    @Expose
    val strDescriptionEN: String,

    @SerializedName("strDescriptionDE")
    @Expose
    val strDescriptionDE: String?,

    @SerializedName("strDescriptionFR")
    @Expose
    val strDescriptionFR: String,

    @SerializedName("strDescriptionCN")
    @Expose
    val strDescriptionCN: String?,

    @SerializedName("strDescriptionIT")
    @Expose
    val strDescriptionIT: String,

    @SerializedName("strDescriptionJP")
    @Expose
    val strDescriptionJP: String?,

    @SerializedName("strDescriptionRU")
    @Expose
    val strDescriptionRU: String?,

    @SerializedName("strDescriptionES")
    @Expose
    val strDescriptionES: String?,

    @SerializedName("strDescriptionPT")
    @Expose
    val strDescriptionPT: String?,

    @SerializedName("strDescriptionSE")
    @Expose
    val strDescriptionSE: String?,

    @SerializedName("strDescriptionNL")
    @Expose
    val strDescriptionNL: String?,

    @SerializedName("strDescriptionHU")
    @Expose
    val strDescriptionHU: String?,

    @SerializedName("strDescriptionNO")
    @Expose
    val strDescriptionNO: String?,

    @SerializedName("strDescriptionIL")
    @Expose
    val strDescriptionIL: String?,

    @SerializedName("strDescriptionPL")
    @Expose
    val strDescriptionPL: String?,

    @SerializedName("strKitColour1")
    @Expose
    val strKitColour1: String,

    @SerializedName("strKitColour2")
    @Expose
    val strKitColour2: String,

    @SerializedName("strKitColour3")
    @Expose
    val strKitColour3: String,

    @SerializedName("strGender")
    @Expose
    val strGender: String,

    @SerializedName("strCountry")
    @Expose
    val strCountry: String,

    @SerializedName("strTeamBadge")
    @Expose
    val strTeamBadge: String,
) : Serializable
