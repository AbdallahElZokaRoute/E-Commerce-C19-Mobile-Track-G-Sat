package com.route.e_commercec19_mobiletrack.gsat.data.categories.repositoriesImpl


import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.entity.CategoryEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRemoteDataSource
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(private val remoteDataSourceImpl: CategoriesRemoteDataSource) :
    CategoriesRepository {
    override suspend fun getCategories(): Flow<ApiResult<List<CategoryEntity>>> {
        return remoteDataSourceImpl.fetchCategories()
    }

}
