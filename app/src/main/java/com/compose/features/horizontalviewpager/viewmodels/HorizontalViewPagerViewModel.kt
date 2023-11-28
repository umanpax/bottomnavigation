package com.compose.features.horizontalviewpager.viewmodels

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.compose.features.horizontalviewpager.models.HorizontalPagerContent
import com.compose.features.horizontalviewpager.states.HorizontalViewPagerViewState
import com.compose.features.league.states.LeagueViewState
import com.compose.model.League
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class HorizontalViewPagerViewModel() : IHorizontalViewPagerViewModel, ViewModel(), KoinComponent {

    private val _stateStream = MutableStateFlow(HorizontalViewPagerViewState())

    init {
        getItems()
    }

    private var state: HorizontalViewPagerViewState
        get() = _stateStream.value
        set(newState) {
            _stateStream.update { newState }
        }


    private fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            state = try {
                state.copy(items = createItems())
            } catch (e: Exception) {
                state.copy(error = e.message.toString())
            }
        }

    }

    private fun createItems() = listOf(
        HorizontalPagerContent(
            title = "Rouge",
            subtitle = "Ceci est la couleur rouge",
            description = "Description1",
            color = Color.Red.toArgb(),
            imageUri = "https://www.tiiitre.fr/categories/amour.png"
        ),
        HorizontalPagerContent(
            title = "Blue",
            subtitle = "Ceci est la couleur bleue",
            description = "Description2",
            color = Color.Blue.toArgb(),
            imageUri = "https://www.tiiitre.fr/categories/animaux.png"
        ),
        HorizontalPagerContent(
            title = "Gris",
            subtitle = "Ceci est la couleur grise",
            description = "Description3",
            color = Color.Gray.toArgb(),
            imageUri = "https://www.tiiitre.fr/categories/animaux_old.png"
        ),
        HorizontalPagerContent(
            title = "Cyan",
            subtitle = "Ceci est la couleur cyan",
            description = "Description4",
            color = Color.Cyan.toArgb(),
            imageUri = "https://www.tiiitre.fr/categories/argent.png"
        ),
        HorizontalPagerContent(
            title = "Magenta",
            subtitle = "Ceci est la couleur magenta",
            description = "Description5",
            color = Color.Magenta.toArgb(),
            imageUri = "https://www.tiiitre.fr/categories/beaute.png"
        )
    )


    override fun getViewState(): StateFlow<HorizontalViewPagerViewState> {
        return _stateStream
    }
}

interface IHorizontalViewPagerViewModel {
    fun getViewState(): StateFlow<HorizontalViewPagerViewState>
}