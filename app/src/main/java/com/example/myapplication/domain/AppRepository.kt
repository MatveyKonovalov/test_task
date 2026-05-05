package com.example.myapplication.domain

interface AppRepository {
    suspend fun getOptions(): List<Variet>
    suspend fun addOption(option: Variet)
}