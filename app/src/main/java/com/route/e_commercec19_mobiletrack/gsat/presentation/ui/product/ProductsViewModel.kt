package com.route.e_commercec19_mobiletrack.gsat.presentation.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.products.entity.ProductEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.products.usecases.GetProductsByCategoryIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase
) : ViewModel() {
    private val _productsListState = MutableStateFlow<List<ProductEntity>>(listOf())
    val productsListState = _productsListState.asStateFlow()

    fun getProductsList(categoryId: String?) {
        viewModelScope.launch {
            val response = getProductsByCategoryIdUseCase(categoryId)
            response.collect {
                when (it) {
                    is ApiResult.Error -> {}
                    is ApiResult.Success -> {
                        _productsListState.value = it.data
                    }
                }

            }
        }
    }

}
