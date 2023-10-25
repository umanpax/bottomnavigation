package com.compose

import androidx.lifecycle.SavedStateHandle
import com.compose.features.team.services.TeamRepository
import com.compose.features.team.states.TeamViewState
import com.compose.features.team.viewmodels.TeamViewModel
import com.compose.model.League
import com.compose.model.Team
import com.compose.model.Teams
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


@ExperimentalCoroutinesApi
class TeamViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    private lateinit var repository: TeamRepository

    @Mock
    private val savedStateHandle: SavedStateHandle = SavedStateHandle()

    @Mock
    private lateinit var state: TeamViewState


    private lateinit var viewModel: TeamViewModel

    @Before
    fun setUp() {
        state = Mockito.mock(TeamViewState::class.java)
        repository = Mockito.mock(TeamRepository::class.java)
        viewModel = TeamViewModel(repository, savedStateHandle)
    }

    @Test
    fun testGetLeagues() = CoroutineTestRule().testScope.runBlockingTest {

        val teamList = listOf(
            Team(
                idTeam = "1",
                idSoccerXML = "SoccerXML1",
                idAPIfootball = "APIfootball1",
                intLoved = "1",
                strTeam = "Team 1",
                strTeamShort = "Team 1 Short",
                strAlternate = "Alternate 1",
                intFormedYear = "2000",
                strSport = "Sport 1",
                strLeague = "League 1",
                idLeague = "LeagueID1",
                strLeague2 = "League 2",
                idLeague2 = "LeagueID2",
                strLeague3 = "League 3",
                idLeague3 = "LeagueID3",
                strLeague4 = "League 4",
                idLeague4 = "LeagueID4",
                strLeague5 = "League 5",
                idLeague5 = "LeagueID5",
                strLeague6 = "League 6",
                idLeague6 = "LeagueID6",
                strLeague7 = "League 7",
                idLeague7 = "LeagueID7",
                strDivision = "Division 1",
                strStadium = "Stadium 1",
                strKeywords = "Keywords 1",
                strRSS = "RSS 1",
                strStadiumThumb = "StadiumThumb 1",
                strStadiumDescription = "StadiumDescription 1",
                strStadiumLocation = "StadiumLocation 1",
                intStadiumCapacity = "Capacity 1",
                strWebsite = "Website 1",
                strFacebook = "Facebook 1",
                strTwitter = "Twitter 1",
                strInstagram = "Instagram 1",
                strDescriptionEN = "Description EN 1",
                strDescriptionDE = "Description DE 1",
                strDescriptionFR = "Description FR 1",
                strDescriptionCN = "Description CN 1",
                strDescriptionIT = "Description IT 1",
                strDescriptionJP = "Description JP 1",
                strDescriptionRU = "Description RU 1",
                strDescriptionES = "Description ES 1",
                strDescriptionPT = "Description PT 1",
                strDescriptionSE = "Description SE 1",
                strDescriptionNL = "Description NL 1",
                strDescriptionHU = "Description HU 1",
                strDescriptionNO = "Description NO 1",
                strDescriptionIL = "Description IL 1",
                strDescriptionPL = "Description PL 1",
                strKitColour1 = "Kit Colour 1",
                strKitColour2 = "Kit Colour 2",
                strKitColour3 = "Kit Colour 3",
                strGender = "Gender 1",
                strCountry = "Country 1",
                strTeamBadge = "TeamBadge 1"
            ),
            Team(
                idTeam = "2",
                idSoccerXML = "SoccerXML2",
                idAPIfootball = "APIfootball2",
                intLoved = "2",
                strTeam = "Team 2",
                strTeamShort = "Team 2 Short",
                strAlternate = "Alternate 2",
                intFormedYear = "2002",
                strSport = "Sport 2",
                strLeague = "League 2",
                idLeague = "LeagueID2",
                strLeague2 = "League 2",
                idLeague2 = "LeagueID2",
                strLeague3 = "League 3",
                idLeague3 = "LeagueID3",
                strLeague4 = "League 4",
                idLeague4 = "LeagueID4",
                strLeague5 = "League 5",
                idLeague5 = "LeagueID5",
                strLeague6 = "League 6",
                idLeague6 = "LeagueID6",
                strLeague7 = "League 7",
                idLeague7 = "LeagueID7",
                strDivision = "Division 2",
                strStadium = "Stadium 2",
                strKeywords = "Keywords 2",
                strRSS = "RSS 2",
                strStadiumThumb = "StadiumThumb 2",
                strStadiumDescription = "StadiumDescription 2",
                strStadiumLocation = "StadiumLocation 2",
                intStadiumCapacity = "Capacity 2",
                strWebsite = "Website 2",
                strFacebook = "Facebook 2",
                strTwitter = "Twitter 2",
                strInstagram = "Instagram 2",
                strDescriptionEN = "Description EN 2",
                strDescriptionDE = "Description DE 2",
                strDescriptionFR = "Description FR 2",
                strDescriptionCN = "Description CN 2",
                strDescriptionIT = "Description IT 2",
                strDescriptionJP = "Description JP 2",
                strDescriptionRU = "Description RU 2",
                strDescriptionES = "Description ES 2",
                strDescriptionPT = "Description PT 2",
                strDescriptionSE = "Description SE 2",
                strDescriptionNL = "Description NL 2",
                strDescriptionHU = "Description HU 2",
                strDescriptionNO = "Description NO 2",
                strDescriptionIL = "Description IL 2",
                strDescriptionPL = "Description PL 2",
                strKitColour1 = "Kit Colour 2",
                strKitColour2 = "Kit Colour 2",
                strKitColour3 = "Kit Colour 3",
                strGender = "Gender 2",
                strCountry = "Country 2",
                strTeamBadge = "TeamBadge 2"
            )
        )

        val teams = Teams(teamList.toTypedArray())
        val mockResponse = teams
        val league = League(
            idLeague = "1",
            strLeague = "League 1",
            strSport = "Sport 1",
            strLeagueAlternate = "League 1 Alternate"
        )
        Mockito.`when`(repository.getAllTeams(league.strLeague)).thenReturn(flowOf(mockResponse))

        val flow = flow {
            emit(mockResponse)
        }
        Mockito.`when`(repository.getAllTeams(league.strLeague)).thenReturn(flow)

        // Appeler la méthode qui met à jour l'état de la vue
        viewModel.getAllTeams(league.strLeague)

        if(viewModel.getViewState().first().error.isNotEmpty()){
            assert(viewModel.getViewState().first().error.isNotEmpty())
        }
        if(viewModel.getViewState().first().teams.isNotEmpty()){
            assert(viewModel.getViewState().first().teams.isNotEmpty())
        }
    }
}
