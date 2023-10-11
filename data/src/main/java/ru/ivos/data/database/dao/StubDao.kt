package ru.ivos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ivos.data.features.stub.entity.StubEntityOne

@Dao
interface StubDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStubEntity(stubEntityOne: StubEntityOne)

    @Query("DELETE FROM stub_table_one")
    suspend fun deleteAllStubs()

    @Query("DELETE FROM stub_table_one WHERE id = :id")
    suspend fun deleteStub(id: Int)

    @Query("SELECT * FROM stub_table_one WHERE id = :id")
    suspend fun getStub(id: Int): StubEntityOne?
}
