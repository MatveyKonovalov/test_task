package com.example.myapplication.data.di

import com.example.myapplication.data.AppRepositoryImpl
import com.example.myapplication.domain.AppRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: AppRepositoryImpl): AppRepository
}