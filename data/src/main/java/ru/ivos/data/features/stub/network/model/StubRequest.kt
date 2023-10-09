package ru.ivos.data.features.stub.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StubRequest(
    @SerialName("stubFieldOne")
    val stubFieldOne: String,
    @SerialName("stubFieldTwo")
    val stubFieldTwo: String,
)
