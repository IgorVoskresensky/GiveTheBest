package ru.ivos.domain.stub.usecase

data class StubCollectUseCase(
    val stubNetworkUseCase: StubNetworkUseCase,
    val stubLocalUseCase: StubLocalUseCase,
)
