package ru.ivos.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.ivos.common.utils.BASE_URL
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class KtorHttpClientModule {

    @[Provides Singleton]
    fun provideHttpClient() : HttpClient {
        return HttpClient(OkHttp) {

            Logging {
                logger = KtorLogger()
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = BASE_URL
                }

                header(ACCEPT, APP_JSON)
                header(CONTENT_TYPE, APP_JSON)
                header(USER_AGENT, USER_AGENT_VALUE)
            }

            engine {
                config {
                    connectTimeout(1, TimeUnit.MINUTES)
                    readTimeout(30, TimeUnit.SECONDS)
                    writeTimeout(30, TimeUnit.SECONDS)
                }
            }
        }
    }

    companion object {
        const val CONTENT_TYPE = "Content-Type"
        private const val APP_JSON = "application/json"
        private const val ACCEPT = "Accept"
        private const val AUTH = "Authorization"
        private const val USER_AGENT = "User-Agent"
        private const val USER_AGENT_VALUE = ""
    }
}
