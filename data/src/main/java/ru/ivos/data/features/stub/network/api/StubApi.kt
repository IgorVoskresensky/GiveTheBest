package ru.ivos.data.features.stub.network.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import ru.ivos.data.features.stub.network.model.StubRequest
import ru.ivos.data.features.stub.network.model.StubResponse
import javax.inject.Inject

class StubApi @Inject constructor(
    private val httpClient: HttpClient,
) {

    suspend fun execute(stubRequest: StubRequest): StubResponse {
        return httpClient.post("stub/") {
            setBody(stubRequest)
        }.body()
    }
}
