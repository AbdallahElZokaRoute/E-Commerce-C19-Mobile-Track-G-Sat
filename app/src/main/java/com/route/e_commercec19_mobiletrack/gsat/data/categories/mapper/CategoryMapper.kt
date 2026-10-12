package com.route.e_commercec19_mobiletrack.gsat.data.categories.mapper

import com.route.e_commercec19_mobiletrack.gsat.data.categories.model.CategoryDTO
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.entity.CategoryEntity

fun CategoryDTO.toDomain(): CategoryEntity =
    CategoryEntity(
        image = image,
        createdAt = createdAt,
        name = name,
        id = id,
        slug = slug,
        updatedAt = updatedAt
    )
