package com.compose.features.horizontalviewpager.models

data class HorizontalPagerContent(
    val title: String,
    val subtitle: String,
    val description: String,
    val color: Int,
    val imageUri: String? = null
)