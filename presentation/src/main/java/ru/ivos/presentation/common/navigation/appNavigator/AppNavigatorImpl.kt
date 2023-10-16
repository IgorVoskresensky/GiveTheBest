package ru.ivos.presentation.common.navigation.appNavigator

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.ivos.common.utils.constants.INT_ONE
import ru.ivos.common.utils.constants.INT_ZERO
import ru.ivos.presentation.common.navigation.direction.NavigationDirection
import ru.ivos.presentation.common.navigation.direction.NavigationIntent
import ru.ivos.presentation.common.navigation.direction.NavigationIntent.NavigateBack
import ru.ivos.presentation.common.navigation.direction.NavigationIntent.NavigateTo
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {

    override val navigationFlow: MutableSharedFlow<NavigationIntent> = MutableSharedFlow(
        replay = INT_ZERO,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
        extraBufferCapacity = INT_ONE,
    )

    override fun navigate(navigationDirection: NavigationDirection) {
        when (navigationDirection.navigationIntent()) {
            is NavigateBack -> {
                navigateBack(navigationDirection.navigationIntent())
            }

            is NavigateTo -> {
                navigateTo(navigationDirection.navigationIntent())
            }
        }
    }

    private fun navigateBack(navigateBack: NavigationIntent) {
        navigationFlow.tryEmit(navigateBack)
    }

    private fun navigateTo(navigateTo: NavigationIntent) {
        navigationFlow.tryEmit(navigateTo)
    }
}
