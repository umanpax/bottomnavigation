package com.compose

import androidx.lifecycle.SavedStateHandle
import com.compose.features.league.services.LeagueRepository
import com.compose.features.league.states.LeagueViewState
import com.compose.features.league.viewmodels.LeagueViewModel
import com.compose.model.League
import com.compose.model.Leagues
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito


@ExperimentalCoroutinesApi
class LeagueViewModelTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    private lateinit var repository: LeagueRepository

    @Mock
    private val savedStateHandle: SavedStateHandle = SavedStateHandle()

    @Mock
    private lateinit var state: LeagueViewState


    @Captor
    private lateinit var captor: ArgumentCaptor<LeagueViewState>


    private lateinit var viewModel: LeagueViewModel

    @Before
    fun setUp() {
        state = Mockito.mock(LeagueViewState::class.java)
        repository = Mockito.mock(LeagueRepository::class.java)
        viewModel = LeagueViewModel(repository, savedStateHandle)
    }

    @Test
    fun testGetLeagues() = coroutineTestRule.testScope.runBlockingTest {
        val mockResponse = Leagues(
            data = arrayOf(
                League(
                    idLeague = "1",
                    strLeague = "League 1",
                    strSport = "Sport 1",
                    strLeagueAlternate = "League 1 Alternate"
                ),
                League(
                    idLeague = "2",
                    strLeague = "League 2",
                    strSport = "Sport 2",
                    strLeagueAlternate = "League 2 Alternate"
                ),
            )
        )

        val flow = flow {
            emit(mockResponse)
        }
        Mockito.`when`(repository.getAllLeagues()).thenReturn(flow)

        viewModel.getLeagues()
        assert(viewModel.getViewState().first().leagues.isNotEmpty())
        if(viewModel.getViewState().first().error.isNotEmpty()){
            assert(viewModel.getViewState().first().leagues.isEmpty())
            assert(viewModel.getViewState().first().error.isNotEmpty())
        }

        if(viewModel.getViewState().first().leagues.isNotEmpty()){
            assert(viewModel.getViewState().first().error.isEmpty())
            assert(viewModel.getViewState().first().leagues.isNotEmpty())
        }
    }

}
