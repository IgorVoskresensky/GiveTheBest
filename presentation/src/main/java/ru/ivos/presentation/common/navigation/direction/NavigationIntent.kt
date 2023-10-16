package ru.ivos.presentation.common.navigation.direction

import ru.ivos.common.utils.constants.EMPTY_STRING

sealed class NavigationIntent {

    data class NavigateBack(
        val route: String = EMPTY_STRING,
        val inclusive: Boolean = false,
        val blockBackNavigation: Boolean = false,
    ) : NavigationIntent()

    data class NavigateTo(
        val route: String = EMPTY_STRING,
        val popUpToRoute: String = EMPTY_STRING,
        val inclusive: Boolean = false,
        val blockBackNavigation: Boolean = false,
    ) : NavigationIntent()
}
