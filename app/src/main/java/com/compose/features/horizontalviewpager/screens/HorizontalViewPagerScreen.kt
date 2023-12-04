package com.compose.features.horizontalviewpager.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.common.ImageFromUrl
import com.compose.features.horizontalviewpager.models.HorizontalPagerContent
import com.compose.features.horizontalviewpager.states.HorizontalViewPagerViewState
import com.compose.features.horizontalviewpager.viewmodels.HorizontalViewPagerViewModel
import org.koin.androidx.compose.getViewModel
import kotlin.math.absoluteValue

@Composable
fun HorizontalViewPagerScreen(viewModel: HorizontalViewPagerViewModel = getViewModel()) {

    val viewState: HorizontalViewPagerViewState by viewModel.getViewState()
        .collectAsStateWithLifecycle()
    val context = LocalContext.current

    if (viewState.items.isNotEmpty()) {
        DisplayHorizontalViewPager(items = viewState.items)
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayHorizontalViewPager(items: List<HorizontalPagerContent>) {

    val pagerState = rememberPagerState(pageCount = {
        items.size
    })
    Column {
        HorizontalPager(state = pagerState) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
                    .background(
                        color = Color(items[page].color),
                        shape = RoundedCornerShape(16.dp) // Arrondir les coins de la Box
                    )
                    .padding(16.dp)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        alpha = lerp(
                            start = 0.5.dp,
                            stop = 1.dp,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).value

                    }
            ) {

                ImageFromUrl(url = items[page].imageUri!!, size = 100)
                Text(
                    text = items[page].title,
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.Center)
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        DisplayPagerIndicator(items = items, page = pagerState.currentPage)
    }
}


@Composable
fun DisplayPagerIndicator(items: List<HorizontalPagerContent>, page: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(16.dp) // Arrondir les coins de la Box
            )
            .height(200.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        items.forEachIndexed { index, _ ->
            val indicatorColor = if (index == page) Color.Red else Color.DarkGray
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(
                        color = indicatorColor,
                        shape = CircleShape
                    )
            )
            if (index < items.size - 1) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}


