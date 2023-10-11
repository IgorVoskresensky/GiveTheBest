package ru.ivos.data.features.stub.repository

import arrow.core.raise.either
import ru.ivos.common.failure.Failure
import ru.ivos.data.features.stub.mapper.toStubDomainModel
import ru.ivos.data.features.stub.mapper.toStubRequest
import ru.ivos.data.features.stub.source.StubLocalSource
import ru.ivos.data.features.stub.source.StubNetworkSource
import ru.ivos.domain.stub.model.StubDomainModel
import ru.ivos.domain.stub.repository.StubRepository
import javax.inject.Inject

class StubRepositoryImpl @Inject constructor(
    private val local: StubLocalSource,
    private val network: StubNetworkSource,
) : StubRepository {

    override suspend fun doSomethingByNetwork(stubDomainModel: StubDomainModel) =
        either<Failure, StubDomainModel> {
            network.getStubFromNetwork(
                stubDomainModel.toStubRequest()
            ).toStubDomainModel()
        }

    override suspend fun doSomethingLocally(id: Int) = either<Failure, StubDomainModel> {
        local.getStub(id).toStubDomainModel()
    }
}
