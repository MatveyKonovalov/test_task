package com.example.myapplication.data

import com.example.myapplication.domain.AppRepository
import com.example.myapplication.domain.Variet
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val optionDao: OptionDao,
    private val optionMapper: OptionMapper
) : AppRepository {
    override suspend fun getOptions(): List<Variet> {
        val optionsEntity = optionDao.getOptions()
        return optionsEntity.map{optionMapper.toDomain(it)}
    }

    override suspend fun addOption(option: Variet): Unit{
        optionDao.insertOption(optionMapper.toEntity(option))
    }

}