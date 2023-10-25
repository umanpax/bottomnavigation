package com.compose.features.onboarding.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.compose.MainActivity
import com.compose.R
import com.compose.common.DisplayActionButton
import com.compose.features.main.viewmodels.MainScreenViewModel
import com.compose.utils.Constants
import com.compose.utils.PrefsManager
import org.koin.androidx.compose.getViewModel
import org.koin.compose.koinInject

@Composable
fun EndScreen(
    viewModel: MainScreenViewModel = getViewModel(),
    prefsManager: PrefsManager = koinInject()
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Column {
            DisplayActionButton(
                text = stringResource(id = R.string.go),
                onClickedButton = {
                    prefsManager.apply {
                        setBooleanInPreferences(Constants.ONBOARDING_COMPLETED, true)
                        setStringInPreferences(Constants.FIRSTNAME, viewModel.firstName)
                        setStringInPreferences(Constants.LASTNAME, viewModel.lastName)
                    }
                    val intent = Intent(context, MainActivity::class.java)
                    (context as Activity).finish()
                    context.startActivity(intent)
                }
            )
        }

    }

}