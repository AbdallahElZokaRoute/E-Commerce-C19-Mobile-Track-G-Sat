package com.route.e_commercec19_mobiletrack.gsat.data.products.dataSource

import com.route.e_commercec19_mobiletrack.gsat.data.api.productsService.ProductsService
import com.route.e_commercec19_mobiletrack.gsat.data.api.utls.safeApiCall
import com.route.e_commercec19_mobiletrack.gsat.data.mapperUtil.mapResource
import com.route.e_commercec19_mobiletrack.gsat.data.products.mapper.toDomain
import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.ProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.SingleProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRemoteDataSourceImpl @Inject constructor(
    private val service: ProductsService
) : ProductsRemoteDataSource {
    override suspend fun fetchProductsByCategoryId(categoryId: String?): Flow<ApiResult<List<ProductEntity>>> =
        safeApiCall {
            service.fetchProducts(categoryId)
        }.mapResource {
            it.data?.map { it.toDomain() } ?: listOf()
        }

    override suspend fun fetchProductByProductId(productId: String?): Flow<ApiResult<SingleProductEntity?>> =
        safeApiCall {
            service.fetchProductById(productId)
        }.mapResource {
            it.data?.toDomain()
        }

}