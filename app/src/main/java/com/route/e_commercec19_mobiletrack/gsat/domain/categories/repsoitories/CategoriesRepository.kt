package com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories

import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {
    suspend fun getCategories(): Flow<ApiResult<List<CategoryEntity>>>
}

interface CategoriesRemoteDataSource {
    suspend fun fetchCategories(): Flow<ApiResult<List<CategoryEntity>>>
}
