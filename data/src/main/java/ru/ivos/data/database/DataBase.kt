package ru.ivos.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.ivos.data.features.stub.dao.dao.StubDao
import ru.ivos.data.features.stub.dao.entity.StubEntity

@Database(
    entities = [
        StubEntity::class,
    ], version = 1
)
abstract class DataBase : RoomDatabase()  {

    abstract fun stubDao(): StubDao

    companion object {
        private const val databaseName = "mvno_db"

        fun buildDatabase(context: Context): DataBase =
            Room.databaseBuilder(context, DataBase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
    }
}
