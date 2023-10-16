package ru.ivos.presentation.common.navigation.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.ivos.presentation.common.navigation.screens.BottomNavigation.LoginNavObject

object BottomScreensNav {

    val bottomNavObjects by lazy {
        listOf(
            LoginNavObject,
        )
    }

    fun NavGraphBuilder.bottomNavigationScreens() {
        composable(LoginNavObject.route) { from ->
            /*LoginScreen()*/
        }
    }
}
