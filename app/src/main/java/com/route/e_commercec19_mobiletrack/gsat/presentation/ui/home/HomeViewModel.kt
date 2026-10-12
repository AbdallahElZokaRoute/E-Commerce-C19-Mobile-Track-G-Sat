package com.route.e_commercec19_mobiletrack.gsat.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.e_commercec19_mobiletrack.gsat.data.categories.model.CategoryDTO
import com.route.e_commercec19_mobiletrack.gsat.data.api.utls.AppExceptions
import com.route.e_commercec19_mobiletrack.gsat.domain.ApiResult
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.entity.CategoryEntity
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.usecase.GetCategoriesUseCase
import com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.coroutines.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) : ViewModel() {
    private val _productsState = MutableStateFlow<List<Product>>(listOf())
    val productsState = _productsState.asStateFlow()
    private val _categoriesState = MutableStateFlow<List<CategoryEntity>>(listOf())
    val categoriesState = _categoriesState.asStateFlow()
    private val _errorSharedFlow = MutableSharedFlow<AppExceptions>()
    val errorSharedFlow = _errorSharedFlow.asSharedFlow()

    fun getCategories() {
        viewModelScope.launch {
            val response = getCategoriesUseCase()
            response.collect {
                when (it) {
                    is ApiResult.Error -> when (it.message) {
                        is AppExceptions.ClientError -> {
                            Log.e("TAG", "getCategories: Client Exception : ${it.message.message}")
                            _errorSharedFlow.emit(it.message)
                        }

                        AppExceptions.NoDataException -> {
                            _errorSharedFlow.emit(it.message)
                        }

                        is AppExceptions.ServerException -> {
                            it.message
                        }

                        is AppExceptions.UnknownError -> {}
                        null -> {
                            it.message
                        }
                    }

                    is ApiResult.Success -> {
                        _categoriesState.value = it.data ?: listOf()
                    }
                }
            }

        }
    }
    /*
        fun getProducts() {
            viewModelScope.launch(context = Dispatchers.IO) {
                try {
                    delay(2_000)
                    _productsState.value = listOf(Product(Random.nextInt(1, 100)))
                } catch (e: Exception) {
                    _errorSharedFlow.emit(e.message ?: "")

                }
            }

    }*/
}