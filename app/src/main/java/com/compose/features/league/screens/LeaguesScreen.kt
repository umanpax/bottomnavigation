package com.compose.features.league.screens

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.R
import com.compose.common.DialogComponent
import com.compose.common.DisplayTextWithActionButtons
import com.compose.features.league.states.LeagueViewState
import com.compose.features.league.viewmodels.LeagueViewModel
import com.compose.model.League
import org.koin.androidx.compose.getViewModel

@Composable
fun LeaguesScreen(
    navigateToTeam: (String) -> Unit,
    viewModel: LeagueViewModel = getViewModel()
) {

    val viewState: LeagueViewState by viewModel.getViewState().collectAsStateWithLifecycle()
    val context = LocalContext.current

    if (viewState.leagues.isNotEmpty()) {
        ListLeagues(listLeagues = viewState.leagues,
            navigateToTeam = navigateToTeam,
            onDeleteAction = { league ->
                viewModel.deleteLeague(league)
            },
            onDuplicate = { league ->
                viewModel.setLeagueToDuplicate(league)
                viewModel.showDuplicationDialog(true)
            })
    }

    if (viewState.error.isNotEmpty()) {
        Toast.makeText(context, viewState.error, Toast.LENGTH_LONG).show()
    }

    DialogComponent(
        titleDialog = stringResource(id = R.string.duplicate_league),
        textDialog =  stringResource(R.string.continue_to_duplicate_league,
            viewState.league?.strLeague ?: ""
        ),
        positiveButtonText =  stringResource(R.string.ok),
        negativeButtonText =  stringResource(R.string.cancel),
        positiveButtonAction = {
            viewModel.duplicateLeague(viewState.league!!)
        },
        negativeButtonAction = {
            viewModel.showDuplicationDialog(false)
        },
        isDialogOpen = viewState.showDuplicationDialog
    )
}

@Composable
fun ListLeagues(
    listLeagues: List<League>,
    navigateToTeam: (String) -> Unit,
    onDeleteAction: (league: League) -> Unit,
    onDuplicate: (item: League) -> Unit
) {
    LazyColumn {
        itemsIndexed(listLeagues) { index, item ->
            ItemLeague(item, onClickedText = {
                navigateToTeam(item.strLeague)
            }, onDeleteAction = {
                onDeleteAction.invoke(item)
            }, onDuplicate = {
                onDuplicate.invoke(item)
            })
        }
    }
}

@Composable
fun ItemLeague(
    league: League,
    onClickedText: () -> Unit,
    onDeleteAction: (item: League) -> Unit,
    onDuplicate: (item: League) -> Unit
) {
    DisplayTextWithActionButtons(
        text = league.strLeague,
        textButton1 = R.string.delete,
        onClickedText = { if (league.canBeDuplicate) {
            onClickedText.invoke()
        } },
        onClickedButton1 = { onDeleteAction(league) },
        textButton2 = if (league.canBeDuplicate) R.string.duplicate else null,
        onClickedButton2 = {
            if (league.canBeDuplicate) {
                onDuplicate(league)
            }
        },
    )
}
