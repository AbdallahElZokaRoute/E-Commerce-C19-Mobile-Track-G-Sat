package com.route.e_commercec19_mobiletrack.gsat.domain.categories.usecase

import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: CategoriesRepository) {
    suspend operator fun invoke() = repository.getCategories()
}
