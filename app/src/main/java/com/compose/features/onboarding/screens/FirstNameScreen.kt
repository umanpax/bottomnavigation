package com.compose.features.onboarding.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.compose.R
import com.compose.common.DisplayActionButton
import com.compose.common.DisplayEditable
import com.compose.features.main.viewmodels.MainScreenViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun FirstNameScreen(
    navigateToLastName: () -> Unit,
    viewModel: MainScreenViewModel = getViewModel()
) {

    var firstNameIsFilled by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Column {
            DisplayEditable(text = R.string.first_name, onValueChanged = {
                firstNameIsFilled = it.text.isNotEmpty()
                viewModel.firstName = it.text
            })
            Spacer(modifier = Modifier.height(16.dp))
            DisplayActionButton(
                text = stringResource(id = R.string.next),
                onClickedButton = {
                    if (firstNameIsFilled) {
                        navigateToLastName()
                    } else {
                        Toast.makeText(context, "Please enter your first name", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            )

        }
    }


}

