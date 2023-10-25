package com.compose.features.team.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.compose.features.team.services.TeamRepository
import com.compose.features.team.states.TeamViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class TeamViewModel(val repository: TeamRepository, savedStateHandle: SavedStateHandle) : ViewModel(), KoinComponent {

    private val _stateStream = MutableStateFlow(TeamViewState())
    private val leagueString = savedStateHandle.get<String>("league")

    private var state: TeamViewState
        get() = _stateStream.value
        set(newState) {
            _stateStream.update { newState }
        }

    init {
        if (leagueString != null) {
            getAllTeams(leagueString)
        }
    }
     fun getAllTeams(league : String){
         CoroutineScope(Dispatchers.IO).launch{
             repository.getAllTeams(league).collectLatest {
                 state = try {
                     state.copy(teams = it.data.toMutableList())
                 } catch (e: Exception) {
                     state.copy(error = e.message.toString())
                 }
             }
         }
    }
    fun getViewState(): StateFlow<TeamViewState> = _stateStream.asStateFlow()
}