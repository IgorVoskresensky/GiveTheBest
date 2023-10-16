package ru.ivos.presentation.common.navigation.screens

import androidx.annotation.StringRes
import ru.ivos.common.utils.constants.DEFAULT_INT
import ru.ivos.presentation.R
import ru.ivos.presentation.common.navigation.direction.NavigationComposable

sealed class BottomNavigation(
    @StringRes override val label: Int,
    override val route: String,
    override val icon: Int = DEFAULT_INT,
)  : NavigationComposable {

    data object LoginNavObject : BottomNavigation(
        route = "LoginScreen",
        label = R.string.empty,
        icon = R.drawable.ic_launcher_foreground,
    )
}
