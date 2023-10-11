package ru.ivos.domain.stub.usecase

import ru.ivos.domain.stub.model.StubDomainModel
import ru.ivos.domain.stub.repository.StubRepository
import javax.inject.Inject

class StubNetworkUseCase @Inject constructor(
    private val repository: StubRepository,
) {

    suspend operator fun invoke(stubDomainModel: StubDomainModel) =
        repository.doSomethingByNetwork(stubDomainModel)
}
