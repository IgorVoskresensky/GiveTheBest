package ru.ivos.data.features.stub.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stub_table")
data class StubEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("stubFieldOne")
    val stubFieldOne: String,
    @ColumnInfo("stubFieldTwo")
    val stubFieldTwo: String,
)
