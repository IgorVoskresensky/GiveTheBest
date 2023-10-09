package ru.ivos.data.network

import android.util.Log
import io.ktor.client.plugins.logging.*

class KtorLogger : Logger {

    override fun log(message: String) {
        Log.d(this::class.simpleName, message)
    }
}
