package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface OptionDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOption(option: OptionEntity): Long

    @Query("SELECT * FROM options where id = :id")
    suspend fun getOptionById(id: String): List<OptionEntity>

    @Query("SELECT * FROM options")
    suspend fun getOptions(): List<OptionEntity>
}