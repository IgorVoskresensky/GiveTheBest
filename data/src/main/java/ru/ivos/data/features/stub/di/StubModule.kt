package ru.ivos.data.features.stub.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.ivos.data.features.stub.repository.StubRepositoryImpl
import ru.ivos.data.features.stub.source.StubLocalSource
import ru.ivos.data.features.stub.source.StubLocalSourceImpl
import ru.ivos.data.features.stub.source.StubNetworkSource
import ru.ivos.data.features.stub.source.StubNetworkSourceImpl
import ru.ivos.domain.stub.repository.StubRepository

@[Module InstallIn(ViewModelComponent::class)]
interface StubModule {

    @Binds
    fun bindStubRepository(repositoryImpl: StubRepositoryImpl): StubRepository

    @Binds
    fun bindLocalSource(sourceImpl: StubLocalSourceImpl): StubLocalSource

    @Binds
    fun bindNetworkSource(sourceImpl: StubNetworkSourceImpl): StubNetworkSource
}
