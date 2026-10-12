package com.route.e_commercec19_mobiletrack.gsat.domain.products.usecases

import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRepository
import javax.inject.Inject

class GetProductByProductIdUseCase @Inject constructor(private val repository: ProductsRepository) {
    suspend operator fun invoke(productId: String) = repository.getProductByProductId(productId)
}