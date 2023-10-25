package com.compose.di

import androidx.lifecycle.SavedStateHandle
import com.compose.features.league.services.LeagueDataManager
import com.compose.features.league.services.LeagueRepository
import com.compose.features.league.viewmodels.LeagueViewModel
import com.compose.features.main.viewmodels.MainScreenViewModel
import com.compose.features.team.services.TeamDataManager
import com.compose.features.team.services.TeamRepository
import com.compose.features.team.viewmodels.TeamViewModel
import com.compose.utils.PrefsManager
import com.compose.utils.ServiceGenerator
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulePrefsManager = module { factory { PrefsManager(_context = androidContext()) } }

val moduleTeamRepository =
    module { factory { TeamRepository(dataManager = TeamDataManager(serviceGenerator = ServiceGenerator())) } }

val moduleLeagueRepository =
    module { factory { LeagueRepository(dataManager = LeagueDataManager(serviceGenerator = ServiceGenerator())) } }


val leagueViewModel = module {
    viewModel {
        LeagueViewModel(
            repository = LeagueRepository(
                dataManager = LeagueDataManager(serviceGenerator = ServiceGenerator())
            ),
            savedStateHandle = get()
        )
    }
}


val teamViewModel = module {
    viewModel {
        TeamViewModel(
            repository = TeamRepository(
                dataManager = TeamDataManager(serviceGenerator = ServiceGenerator())
            ),
            savedStateHandle = get()
        )
    }
}

val mainScreenViewModel = module {
    single { MainScreenViewModel() }
}



val koinUiModules = listOf(
    modulePrefsManager,
    moduleLeagueRepository,
    moduleTeamRepository,
    leagueViewModel,
    teamViewModel,
    mainScreenViewModel
)