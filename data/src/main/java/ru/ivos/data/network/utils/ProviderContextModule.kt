package ru.ivos.data.network.utils

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface ProviderContextModule {

    @Binds
    fun bindContext(
        @ApplicationContext appContext: Context
    ): Context
}
