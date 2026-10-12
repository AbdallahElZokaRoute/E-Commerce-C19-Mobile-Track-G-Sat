package com.route.e_commercec19_mobiletrack.gsat.data.categories.dataSource.remote

import com.route.e_commercec19_mobiletrack.gsat.data.api.categoriesApis.CategoriesService
import com.route.e_commercec19_mobiletrack.gsat.data.api.utls.safeApiCall
import com.route.e_commercec19_mobiletrack.gsat.data.categories.mapper.toDomain
import com.route.e_commercec19_mobiletrack.gsat.data.mapperUtil.mapResource
import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.entity.CategoryEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRemoteDataSource
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class CategoriesRemoteDataSourceImpl @Inject constructor(
    private val service: CategoriesService
) : CategoriesRemoteDataSource {
    override suspend fun fetchCategories(): Flow<ApiResult<List<CategoryEntity>>> = safeApiCall {
        service.fetchCategories()
    }.mapResource {
        it.data?.map { it.toDomain() } ?: listOf()
    }
}
