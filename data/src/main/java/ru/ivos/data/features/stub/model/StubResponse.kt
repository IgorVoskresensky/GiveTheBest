package ru.ivos.data.features.stub.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StubResponse(
    @SerialName("stubFieldOne")
    val stubFieldOne: String,
    @SerialName("stubFieldTwo")
    val stubFieldTwo: String,
)
