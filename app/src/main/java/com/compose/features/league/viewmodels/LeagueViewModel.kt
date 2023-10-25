package com.compose.features.league.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.compose.features.league.services.LeagueRepository
import com.compose.features.league.states.LeagueViewState
import com.compose.model.League
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class LeagueViewModel(
    private val repository: LeagueRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), ILeagueViewModel, KoinComponent {

    private val _stateStream = MutableStateFlow(LeagueViewState())

    init {
        getLeagues()
    }

    private var state: LeagueViewState
        get() = _stateStream.value
        set(newState) {
            _stateStream.update { newState }
        }

    fun getLeagues() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getAllLeagues().collectLatest {
                state = try {
                    val listLeague = it.data.sortedBy { it.strLeague }.toMutableList()
                    listLeague.map { it.canBeDuplicate = true }
                    state.copy(leagues = listLeague)
                } catch (e: Exception) {
                    state.copy(error = e.message.toString())
                }
            }
        }
    }


    override fun deleteLeague(league: League) {
        CoroutineScope(Dispatchers.IO).launch {
            val listLeague = state.leagues.toMutableList()
            listLeague.remove(league)
            state = state.copy(leagues = listLeague)
        }
    }

    override fun duplicateLeague(league: League) {
        CoroutineScope(Dispatchers.IO).launch {
            val listLeague = state.leagues.toMutableList()
            val indiceItemLeague = listLeague.count { it.strLeague.contains(league.strLeague) }
            val newLeague = League(
                idLeague = league.idLeague,
                strLeague = league.strLeague + "($indiceItemLeague)",
                strSport = league.strSport,
                strLeagueAlternate = league.strLeagueAlternate,
                canBeDuplicate = false
            )
            listLeague.add(newLeague)
            listLeague.sortBy { it.strLeague }
            state = state.copy(leagues = listLeague, showDuplicationDialog = false)
        }
    }

    override fun showDuplicationDialog(value: Boolean) {
        state = state.copy(showDuplicationDialog = value)
    }

    override fun setLeagueToDuplicate(league: League) {
        state = state.copy(league = league)
    }

    override fun getViewState(): StateFlow<LeagueViewState> = _stateStream.asStateFlow()
}

interface ILeagueViewModel {
    fun getViewState(): StateFlow<LeagueViewState>
    fun deleteLeague(league: League)
    fun duplicateLeague(league: League)
    fun showDuplicationDialog(value: Boolean)
    fun setLeagueToDuplicate(league: League)
}