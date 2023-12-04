package com.compose.features.team.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.compose.common.ImageFromUrl
import com.compose.features.team.states.TeamViewState
import com.compose.features.team.viewmodels.TeamViewModel
import com.compose.model.Team
import org.koin.androidx.compose.getViewModel

@Composable
fun TeamsScreen(viewModel: TeamViewModel = getViewModel()) {

    val viewState: TeamViewState by viewModel.getViewState().collectAsStateWithLifecycle()

    if (viewState.teams.isNotEmpty()) {
        CollapsingEffectScreen(viewState.teams)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollapsingEffectScreen(teams: List<Team>) {

    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .background(Color.DarkGray),
        lazyListState,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Modifier.fillMaxWidth()
            Image(
                painter = rememberAsyncImagePainter(model = "https://media.licdn.com/dms/image/D4E03AQHT3najx33eZA/profile-displayphoto-shrink_800_800/0/1678569743798?e=2147483647&v=beta&t=6_4-F8cbMUGIdXirtExVIRhauOJcVkFuPcGUFKgPZMw"),
                alignment = Alignment.Center,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .graphicsLayer {
                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                        translationY = scrolledY * 0.5f
                        scaleX = 1 / ((scrolledY * 0.01f) + 1f)
                        scaleY = 1 / ((scrolledY * 0.01f) + 1f)
                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                    }
                    .size(225.dp)
                    .padding(20.dp)
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
        stickyHeader {
            Text(
                text = "Pierre-Alexandre VEZINET",
                Modifier
                    .background(Color.White)
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
        itemsIndexed(teams) { index, team ->
            TeamItem(team = team)
        }
    }
}


@Composable
fun TeamItem(team: Team) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(BorderStroke(1.dp, Color.White)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ImageFromUrl(url = team.strTeamBadge)

        Text(
            text = team.strTeam,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(130.dp)
                .padding(8.dp),
        )

    }
}



@Preview
@Composable
fun TeamItemPreview() {
    val myTeam = Team(
        idTeam = "1",
        idSoccerXML = "soccer1",
        idAPIfootball = "api1",
        intLoved = "1",
        strTeam = "Mon équipe",
        strTeamShort = "ME",
        strAlternate = "Alternative",
        intFormedYear = "2000",
        strSport = "Football",
        strLeague = "Ma ligue",
        idLeague = "league1",
        strLeague2 = "Ligue 2",
        idLeague2 = "league2",
        strLeague3 = "Ligue 3",
        idLeague3 = "league3",
        strLeague4 = "Ligue 4",
        idLeague4 = "league4",
        strLeague5 = "Ligue 5",
        idLeague5 = "league5",
        strLeague6 = "Ligue 6",
        idLeague6 = "league6",
        strLeague7 = "Ligue 7",
        idLeague7 = "league7",
        strDivision = "Division",
        strStadium = "Stade",
        strKeywords = "Mots-clés",
        strRSS = "RSS",
        strStadiumThumb = "https://exemple.com/stadium-thumb.png",
        strStadiumDescription = "Description du stade",
        strStadiumLocation = "Emplacement du stade",
        intStadiumCapacity = "50000",
        strWebsite = "https://exemple.com",
        strFacebook = "https://facebook.com/mon-equipe",
        strTwitter = "https://twitter.com/mon-equipe",
        strInstagram = "https://instagram.com/mon-equipe",
        strDescriptionEN = "Description en anglais",
        strDescriptionDE = "Description en allemand",
        strDescriptionFR = "Description en français",
        strDescriptionCN = "Description en chinois",
        strDescriptionIT = "Description en italien",
        strDescriptionJP = "Description en japonais",
        strDescriptionRU = "Description en russe",
        strDescriptionES = "Description en espagnol",
        strDescriptionPT = "Description en portugais",
        strDescriptionSE = "Description en suédois",
        strDescriptionNL = "Description en néerlandais",
        strDescriptionHU = "Description en hongrois",
        strDescriptionNO = "Description en norvégien",
        strDescriptionIL = "Description en hébreu",
        strDescriptionPL = "Description en polonais",
        strKitColour1 = "Couleur de kit 1",
        strKitColour2 = "Couleur de kit 2",
        strKitColour3 = "Couleur de kit 3",
        strGender = "Genre",
        strCountry = "Pays",
        strTeamBadge = "https://exemple.com/team-badge.png"
    )

    TeamItem(team = myTeam)
}
