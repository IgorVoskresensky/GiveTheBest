package ru.ivos.data.features.stub.dao.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ivos.data.features.stub.dao.entity.StubEntity

@Dao
interface StubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStubEntity(stubEntity: StubEntity)

    @Query("DELETE FROM stub_table")
    suspend fun deleteAllStubs()

    @Query("DELETE FROM stub_table  WHERE id = :id")
    suspend fun deleteStub(id: Int)

    @Query("SELECT * FROM stub_table WHERE id = :id")
    suspend fun getStub(id: Int): StubEntity?
}
