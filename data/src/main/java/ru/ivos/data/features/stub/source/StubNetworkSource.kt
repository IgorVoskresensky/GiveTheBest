package ru.ivos.data.features.stub.source

import ru.ivos.data.features.stub.model.StubRequest
import ru.ivos.data.features.stub.model.StubResponse
import ru.ivos.data.network.api.StubApi
import javax.inject.Inject

interface StubNetworkSource {

    suspend fun getStubFromNetwork(stubRequest: StubRequest): StubResponse
}

class StubNetworkSourceImpl @Inject constructor(
    private val api: StubApi
) : StubNetworkSource {

    override suspend fun getStubFromNetwork(stubRequest: StubRequest) = api.execute(stubRequest)
}
