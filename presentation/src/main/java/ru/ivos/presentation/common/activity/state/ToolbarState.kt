package ru.ivos.presentation.common.activity.state

import ru.ivos.presentation.R

data class ToolbarState(
    val titleName: Int = R.string.empty,
    val topAppbarVisibility: Boolean = false,
    val navIconVisibility: Boolean = false,
)
