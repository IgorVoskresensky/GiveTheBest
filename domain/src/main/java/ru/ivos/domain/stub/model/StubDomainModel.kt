package ru.ivos.domain.stub.model

import ru.ivos.common.utils.constants.EMPTY_STRING

data class StubDomainModel(
    val stubFieldOne: String = EMPTY_STRING,
    val stubFieldTwo: String = EMPTY_STRING,
)
