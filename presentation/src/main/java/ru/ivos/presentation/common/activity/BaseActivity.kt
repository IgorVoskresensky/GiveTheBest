package ru.ivos.presentation.common.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import ru.ivos.presentation.common.activity.viewmodel.MainActivityViewModel
import ru.ivos.presentation.common.activity.viewmodel.NoNetworkViewModel

abstract class BaseActivity : ComponentActivity() {

    protected val viewModel: MainActivityViewModel by viewModels()
    private val nwViewModel: NoNetworkViewModel by viewModels()

    abstract fun initUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        initUi()
        nwViewModel.registerNetworkCallback()
    }
}
