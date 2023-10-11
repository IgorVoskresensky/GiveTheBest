package ru.ivos.data.features.stub.source

import ru.ivos.data.database.dao.StubDao
import ru.ivos.data.features.stub.entity.StubEntityOne
import javax.inject.Inject

interface StubLocalSource {

    suspend fun insertStubEntity(stubEntityOne: StubEntityOne)

    suspend fun deleteAllStubs()

    suspend fun deleteStub(id: Int)

    suspend fun getStub(id: Int): StubEntityOne?
}

class StubLocalSourceImpl @Inject constructor(
    private val dao: StubDao,
) : StubLocalSource {

    override suspend fun insertStubEntity(stubEntityOne: StubEntityOne) {
        return dao.insertStubEntity(stubEntityOne)
    }

    override suspend fun deleteAllStubs() {
        return dao.deleteAllStubs()
    }

    override suspend fun deleteStub(id: Int) {
        return dao.deleteStub(id)
    }

    override suspend fun getStub(id: Int): StubEntityOne? {
        return dao.getStub(id)
    }
}
