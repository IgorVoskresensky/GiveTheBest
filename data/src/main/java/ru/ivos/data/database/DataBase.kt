package ru.ivos.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.ivos.data.database.dao.StubDao
import ru.ivos.data.features.stub.entity.StubEntityOne
import ru.ivos.data.features.stub.entity.StubEntityTwo

@Database(
    entities = [
        StubEntityOne::class,
        StubEntityTwo::class,
    ], version = 1
)
abstract class DataBase : RoomDatabase()  {

    abstract fun stubDao(): StubDao

    companion object {
        private const val databaseName = "gtb_db"

        fun buildDatabase(context: Context): DataBase =
            Room.databaseBuilder(context, DataBase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
    }
}
