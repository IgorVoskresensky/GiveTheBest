package ru.ivos.presentation.common.navigation.appNavigator

import kotlinx.coroutines.flow.MutableSharedFlow
import ru.ivos.presentation.common.navigation.direction.NavigationDirection
import ru.ivos.presentation.common.navigation.direction.NavigationIntent

interface AppNavigator {

    val navigationFlow: MutableSharedFlow<NavigationIntent>

    fun navigate(navigationDirection: NavigationDirection)
}
