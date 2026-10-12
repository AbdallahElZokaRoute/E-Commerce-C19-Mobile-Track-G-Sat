package com.route.e_commercec19_mobiletrack.gsat.data.api.productsService

import com.route.e_commercec19_mobiletrack.gsat.data.products.model.ProductItemsResponseDTO
import com.route.e_commercec19_mobiletrack.gsat.data.products.model.SingleProductResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductsService {
    @GET("products")
    suspend fun fetchProducts(@Query("category[in]") categoryId: String?): Response<ProductItemsResponseDTO>

    @GET("products/{product_id}")
    suspend fun fetchProductById(@Path("product_id") productId: String?): Response<SingleProductResponseDTO>
}
