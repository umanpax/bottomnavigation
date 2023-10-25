package com.compose.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource


@Composable
fun DialogComponent(
    titleDialog: String,
    textDialog: String,
    positiveButtonText: String,
    negativeButtonText: String,
    positiveButtonAction: () -> Unit,
    negativeButtonAction: () -> Unit,
    isDialogOpen: Boolean
) {
    var displayDialog = isDialogOpen

    if (displayDialog) {
        AlertDialog(
            onDismissRequest = {
                displayDialog = false
            },
            title = { Text(text =  titleDialog) },
            text = { Text(text =  textDialog) },
            confirmButton = {
                DisplayActionButton(
                    text = positiveButtonText,
                    onClickedButton = {
                        positiveButtonAction.invoke()
                        displayDialog = false
                    }
                )
            },
            dismissButton = {
                DisplayActionButton(
                    text = negativeButtonText,
                    onClickedButton = {
                        negativeButtonAction.invoke()
                        displayDialog = false
                    }
                )
            }
        )
    }
}



