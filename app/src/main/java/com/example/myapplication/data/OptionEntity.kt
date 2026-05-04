package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "options")
data class OptionEntity(
    @PrimaryKey
    val id: String,
    val description: String,
)