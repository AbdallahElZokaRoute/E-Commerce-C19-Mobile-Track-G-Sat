package com.route.e_commercec19_mobiletrack.gsat.data.products.repositoriesImpl

import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.ProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.SingleProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRemoteDataSource
import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductsRemoteDataSource
) : ProductsRepository {
    override suspend fun getProductsByCategoryId(categoryId: String?): Flow<ApiResult<List<ProductEntity>>> =
        remoteDataSource.fetchProductsByCategoryId(categoryId)

    override suspend fun getProductByProductId(productId: String?): Flow<ApiResult<SingleProductEntity?>> =
        remoteDataSource.fetchProductByProductId(productId)

}
