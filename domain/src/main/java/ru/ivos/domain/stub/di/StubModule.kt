package ru.ivos.domain.stub.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.ivos.domain.stub.repository.StubRepository
import ru.ivos.domain.stub.usecase.StubLocalUseCase
import ru.ivos.domain.stub.usecase.StubNetworkUseCase

@[Module InstallIn(ViewModelComponent::class)]
class StubModule {

    @Provides
    fun provideStubNetworkUseCase(
        repository: StubRepository,
    ) = StubNetworkUseCase(repository)

    @Provides
    fun provideStubLocalUseCase(
        repository: StubRepository,
    ) = StubLocalUseCase(repository)
}
