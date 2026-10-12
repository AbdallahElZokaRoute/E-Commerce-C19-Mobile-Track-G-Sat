package com.route.e_commercec19_mobiletrack.gsat.data.api.categoriesApis

import com.route.e_commercec19_mobiletrack.gsat.data.categories.model.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoriesService {
    @GET("categories")
    suspend fun fetchCategories(): Response<CategoriesResponse>
}
