package com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial

import com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.extensions.toEGP
import com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.extensions.total

//late int number1 = 10
//lateinit val number1: String


// Dart
//int main(int num1 , int num2){
//    return num1+num2;
//}

// void <==> Unit
// Kotlin
fun add(num1: Int?, num2: Int?): Int? {
    if (num1 != null && num2 != null) {
        return num1.plus(num2)
    }
    return null
    //     50                 null
}

fun printEvenNumberRange() {
    // Loops
//    for(int i = 0 ; i <= 100;i++)  // Dart

    for (i in 0..100) {
        println(i)
    }
}

// classes
/*class Product {
    int id;
    String name;
    String description;
    double price;

    initProudct(this.id,this.name,this.description,this.price);
}*/
fun main() {
//    int number = 5; // Dart
//    var number3 = 10; // Dart
//    final int number4 = 60; // Dart


    var num2: Int = 30
    num2 = 85

    // value
    val num1: Int = 12
//    num1 = 70
    // arithmatic operators
//    +-/ * %                ~/
    // Logical Operators
//    && and
//            || or
//    !not
    // assignment operator
//    =
    // compoarison operators
//    > <  >= == !=

    // Null Safety
//    int? number5 = 5

    var number5: Int? = null  // ? Nullable Data Types
    var manager: String? = "Ahmed"
    println(manager!!.length) // Null Pointer Exception
    // ?.

//    val managerName = manager ?? "Unknown"
    val managerName = manager ?: "Unknown"  // Elvis Operator

    //   !     Dart
    //   !!    Kotlin

    val result = add(
        num2 = 60,
        num1 = 70
    )

    val product1 = Product(
        id = 1,
        name = "V Cola",
        description = "Cola",
        20.0
    )
    product1.id
    Product.category = "Drinks"
    val product2 = Product(
        id = 2,
        name = "CocaCola",
        description = "Cola",
        30.0
    )
    Product.category = "Drinks"
    val productsList: MutableList<Product> = mutableListOf(product1, product2)
    println(productsList.total().toEGP())
    // Mutable List <->  Immutable List
    product1 == product2   // false
    val category1 = Category(
        1,
        "Drinks",
        "Cola and fresh Drinks"
    )
    val category2 = Category(
        1,
        "Drinks",
        "Cola and fresh Drinks"
    )
    category1 == category2  // true
    val db1 = Database
    val db2 = Database
    println(product1.price?.toEGP())
    /*val apiResult: ApiResult<String> = ApiResult.Error("Server is Down")
    when (apiResult) {
        is ApiResult.Error -> {

        }

        is ApiResult.Success -> {

        }
    }*/

}

// copy

data class Category(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null
)

abstract class FoodProducts(
    id: Int? = null,
    name: String? = null,
    description: String? = null,
    price: Double? = null,
    val mealDescription: String? = null
) : Product(
    id = id,
    name = name,
    description = description,
    price = price,
) {
    override fun printDetails() {
        super.printDetails()
        println("Meal Description = $mealDescription")
    }

    abstract fun calculatePrice(): Double?
}

class SteakFoodProduct(
    id: Int? = null,
    name: String? = null,
    description: String? = null,
    price: Double? = null,
    mealDescription: String? = null
) : FoodProducts(id, name, description, price, mealDescription) {
    override fun calculatePrice(): Double? {
        if (price != null)
            return price + price * 0.05
        return null
    }

}
// Open for Extension

open class Product(
    open val id: Int? = null,
    open val name: String? = null,
    open val description: String? = null,
    open val price: Double? = null
) {
    companion object {
        var category: String? = null
    }

    open fun printDetails() {
        println("id= $id")
        println("name= $name")
        println("price= $price")
    }

}

class CartItem(
    override val id: Int? = null,
    override val name: String? = null,
    override val description: String? = null,
    override val price: Double? = null
) : Product()

object Database {
    val name: String = "E-Commerce DB"
    fun doTransaction() {

    }
}

interface ProductPriceCalculator {
    fun calculatePrice(): Double
}

// ApiResult<ProductResponse>
/*sealed class ApiResult2<out T>(val messageCode: String?) {
    data class Success<T>(val data: T) : ApiResult2<T>(messageCode = "OK")
    data class Error(val message: String?) : ApiResult2<Nothing>(messageCode = "Error")
}


sealed interface ApiResult<in T> { // Invariance /   Covariance   / Contravariance
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error(val message: String?) : ApiResult<Nothing>
}
*/