package ru.ivos.presentation.common.activity.state

data class MainActivityUiState(
    val toolbarState: ToolbarState = ToolbarState(),
    val bottomNavState: BottomNavigationState = BottomNavigationState(),
)
