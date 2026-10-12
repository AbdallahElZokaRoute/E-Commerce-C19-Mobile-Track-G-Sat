package com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.withContext

// function that can be pauses/ resumed when available
//  A , B , C

suspend fun getProducts(): List<Product> {
    try {
        delay(1000) // Call endpoint
        return listOf(Product(id = 1, name = "AirPods", price = 1000.0))
    } catch (e: Exception) {
        Log.e("TAG", "getProducts: Error :${e.message} ")
        return listOf()
    }
}

suspend fun B() {
    getProducts()
}

suspend fun C() {

}

//  Flow                     Stream
val numbersFlow = flow<Int> {
    for (i in 0..100) {
        delay(1_000)
        emit(i)
    }
}
val numbers2Flow = flow<Int> {
    emit(2)
    emit(2)
}
val productsState = MutableStateFlow<List<Product>>(listOf())


data class Product(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val price: Double? = null
)

suspend fun main() {
    val scope = CoroutineScope(context = Dispatchers.IO)
    val products = getProducts()
    numbersFlow
    // setter
    productsState.value = getProducts()
    withContext(Dispatchers.Main) {

    }
    Log.e("StateFlow", "StateFlow get Once :  ${productsState.value}")

    numbersFlow.collect {
        Log.e("Collector", "main: $it")
    }


//    viewModelScope


//    onDestroy() {
//        scope.cancel()
//    }
}


