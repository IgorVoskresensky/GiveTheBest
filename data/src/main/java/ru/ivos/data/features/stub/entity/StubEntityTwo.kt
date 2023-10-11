package ru.ivos.data.features.stub.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stub_table_two")
data class StubEntityTwo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("stubFieldOne")
    val stubFieldOne: String,
    @ColumnInfo("stubFieldTwo")
    val stubFieldTwo: String,
)
