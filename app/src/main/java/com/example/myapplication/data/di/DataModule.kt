package com.example.myapplication.data.di

import android.content.Context
import com.example.myapplication.data.DataBase
import com.example.myapplication.data.OptionMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Provides
    @Singleton
    fun provideOptionMapper() = OptionMapper()

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) = DataBase.getDataBase(context)

    @Provides
    @Singleton
    fun provideOptionDao(dataBase: DataBase) = dataBase.getOptionDao()

}