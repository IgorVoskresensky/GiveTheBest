package ru.ivos.domain.stub.usecase

import ru.ivos.domain.stub.repository.StubRepository
import javax.inject.Inject

class StubLocalUseCase @Inject constructor(
    private val repository: StubRepository,
) {

    suspend operator fun invoke(id: Int) = repository.doSomethingLocally(id)
}
