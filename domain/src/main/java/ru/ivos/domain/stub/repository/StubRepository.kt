package ru.ivos.domain.stub.repository

import arrow.core.Either
import ru.ivos.common.failure.Failure
import ru.ivos.domain.stub.model.StubDomainModel

interface StubRepository {

    suspend fun doSomethingByNetwork(stubDomainModel: StubDomainModel): Either<Failure, StubDomainModel>

    suspend fun doSomethingLocally(id: Int): Either<Failure, StubDomainModel>
}
