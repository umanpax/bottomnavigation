package com.compose.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayEditable(text: Int, onValueChanged: (TextFieldValue) -> Unit = {}) {
    var textValue by remember { mutableStateOf(TextFieldValue()) }
    Row {
        TextField(
            value = textValue,
            onValueChange = {
                textValue = it
                onValueChanged(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text(stringResource(id = text)) }
        )
    }
}

