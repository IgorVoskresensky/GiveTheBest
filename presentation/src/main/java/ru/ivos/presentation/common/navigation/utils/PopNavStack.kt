package ru.ivos.presentation.common.navigation.utils

import ru.ivos.presentation.common.navigation.direction.NavigationDirection
import ru.ivos.presentation.common.navigation.direction.NavigationIntent

object PopNavStack : NavigationDirection {

    override fun navigationIntent(): NavigationIntent {
        return NavigationIntent.NavigateBack(
            blockBackNavigation = false,
        )
    }
}
