package ru.ivos.presentation.common.navigation.utils

import androidx.navigation.NavDestination
import androidx.navigation.navOptions
import ru.ivos.presentation.common.navigation.direction.NavigationComposable
import ru.ivos.presentation.common.navigation.direction.NavigationIntent

internal fun List<NavigationComposable>.findRoute(
    destination: NavDestination,
    title: (Int) -> Unit,
) {
    this.find {
        it.route == destination.route || destination.route?.contains(it.route) ?: false
    }?.label?.let {
        title.invoke(it)
    }
}

internal fun NavigationIntent.NavigateTo.buildNavOptions() = navOptions {
    popUpTo(this@buildNavOptions.popUpToRoute) {
        inclusive = this@buildNavOptions.inclusive
    }
}
