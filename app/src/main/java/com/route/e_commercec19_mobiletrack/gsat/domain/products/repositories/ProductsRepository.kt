package com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories

import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.ProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.SingleProductEntity
import kotlinx.coroutines.flow.Flow


interface ProductsRepository {
    suspend fun getProductsByCategoryId(categoryId: String?): Flow<ApiResult<List<ProductEntity>>>
    suspend fun getProductByProductId(productId: String?): Flow<ApiResult<SingleProductEntity?>>
}

interface ProductsRemoteDataSource {
    suspend fun fetchProductsByCategoryId(categoryId: String?): Flow<ApiResult<List<ProductEntity>>>
    suspend fun fetchProductByProductId(productId: String?): Flow<ApiResult<SingleProductEntity?>>
}

