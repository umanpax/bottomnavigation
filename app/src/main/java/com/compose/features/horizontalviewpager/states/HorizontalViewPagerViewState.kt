package com.compose.features.horizontalviewpager.states

import com.compose.features.horizontalviewpager.models.HorizontalPagerContent


data class HorizontalViewPagerViewState(
    val items: List<HorizontalPagerContent> = listOf(),
    val item: HorizontalPagerContent? = null,
    val loading : Boolean = false,
    val error : String = ""
)

