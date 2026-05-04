package com.example.myapplication.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(
    entities = [OptionEntity::class],
    version = 1,
)
abstract class DataBase : RoomDatabase() {
    abstract fun getOptionDao(): OptionDao

    companion object {
        @Volatile
        var INSTANCE: DataBase? = null

        fun getDataBase(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "data_base.bd"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}