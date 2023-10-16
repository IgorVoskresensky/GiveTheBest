package ru.ivos.presentation.common.uiElements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.unit.dp

@Composable
fun ErrorText(
    modifier: Modifier = Modifier,
    message: String,
    requestFocus: Boolean = false,
    focusRequester: FocusRequester = remember { FocusRequester() },
) {
    if (requestFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }

    Text(
        modifier = modifier.padding(start = 8.dp, top = 6.dp),
        text = message,
        color = MaterialTheme.colorScheme.error,
        style = MaterialTheme.typography.bodyMedium
    )
}
