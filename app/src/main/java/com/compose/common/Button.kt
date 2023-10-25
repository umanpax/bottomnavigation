package com.compose.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayActionButton(
    text: String,
    onClickedButton: () -> Unit = {},
) {
    Button(
        border = ButtonDefaults.outlinedButtonBorder,
        onClick = {
            onClickedButton.invoke()
        },
        modifier = Modifier
            .padding(4.dp, 4.dp, 12.dp, 4.dp)
    ) {
        Text(
             text,
            fontSize = 11.sp,
            color = Color.White,
        )
    }
}

