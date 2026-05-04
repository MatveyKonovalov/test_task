package com.example.myapplication.data

import com.example.myapplication.domain.Variet
import javax.inject.Inject

class OptionMapper @Inject constructor() {
    fun toDomain(optionEntity: OptionEntity) =
        Variet(id = optionEntity.id, description = optionEntity.description)

    fun toEntity(variet: Variet) = OptionEntity(
        id = variet.id,
        description = variet.description
    )
}