package com.compose.features.profile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.R
import com.compose.common.DisplayActionButton
import com.compose.common.DisplayEditable
import com.compose.utils.Constants
import com.compose.utils.PrefsManager
import org.koin.compose.koinInject

@Composable
fun ProfileScreen(prefsManager: PrefsManager = koinInject(), navigateToHorizontalViewPager: () -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Nom : " + prefsManager.getStringFromPreferences(Constants.LASTNAME))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Prénom : " + prefsManager.getStringFromPreferences(Constants.FIRSTNAME))

        DisplayActionButton(text = stringResource(id = R.string.clear_preferences), onClickedButton = {
            prefsManager.clearAllPreferences()
        })

        DisplayActionButton(text = stringResource(id = R.string.display_horizontal_viewpager), onClickedButton = {
            navigateToHorizontalViewPager()
        })
    }
}
