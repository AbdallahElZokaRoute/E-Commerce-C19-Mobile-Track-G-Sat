package com.route.e_commercec19_mobiletrack.gsat.domain.products.usecases

import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRepository
import javax.inject.Inject

class GetProductsByCategoryIdUseCase @Inject constructor(private val repository: ProductsRepository) {
    suspend operator fun invoke(categoryId: String?) = repository.getProductsByCategoryId(categoryId)
}