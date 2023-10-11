package ru.ivos.data.features.stub.mapper

import ru.ivos.common.utils.instruments.wrapNull
import ru.ivos.data.features.stub.entity.StubEntityOne
import ru.ivos.data.features.stub.model.StubRequest
import ru.ivos.data.features.stub.model.StubResponse
import ru.ivos.domain.stub.model.StubDomainModel

fun StubDomainModel.toStubRequest() = StubRequest(
    stubFieldOne = this.stubFieldOne,
    stubFieldTwo = this.stubFieldTwo,
)

fun StubResponse.toStubDomainModel() = StubDomainModel(
    stubFieldOne = this.stubFieldOne,
    stubFieldTwo = this.stubFieldTwo,
)

fun StubEntityOne?.toStubDomainModel() = StubDomainModel(
    stubFieldOne = wrapNull(this?.stubFieldOne),
    stubFieldTwo = wrapNull(this?.stubFieldTwo),
)
