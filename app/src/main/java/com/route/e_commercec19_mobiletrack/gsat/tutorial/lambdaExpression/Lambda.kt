package com.route.e_commercec19_mobiletrack.gsat.tutorial.lambdaExpression

import com.route.e_commercec19_mobiletrack.gsat.tutorial.CartItem
import com.route.e_commercec19_mobiletrack.gsat.tutorial.Product

//             Parameters            Return Type
var addLambda: (num1: Int, num2: Int) -> Int = { num1, num2 ->
    println()
    num1 + num2
}

val calculation: (Int, Int) -> Unit = { num1, num2 ->
    print("Success")
}

fun add(num1: Int, num2: Int, afterCalculation: (Int, Int) -> Unit): Int {
    afterCalculation(num1, num2)
    return num1 + num2
}

fun main() {
    val cartItem1 = _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.CartItem(
        id = 1,
        name = "V Cola",
        description = "Cola",
        20.0
    )
    val cartItem2 = _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.CartItem(
        id = 2,
        name = "CocaCola",
        description = "Cola",
        30.0
    )
    val cartItemsList: MutableList<com.route.e_commercec19_mobiletrack.gsat.tutorial.CartItem> = mutableListOf(cartItem1, cartItem2)
    val products = cartItemsList.map { cartItem ->
        _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.tutorial.Product(
            id = cartItem.id,
            name = cartItem.name,
            description = cartItem.description,
            price = cartItem.price
        )
    }
//    .filter {
//        (it.price ?: 0.0) < 25
//    }
    val productsMap = products.groupBy { it.description }
    productsMap.keys.forEach { it ->
        println("$it")
        for (value in productsMap.getValue(it)) {
            println("   ${value.name}  :  ${value.price}")
        }

    }
    // Description ->
//            Food :
//                Chocolate
//                Chipsy
//            Drinks :
//                V Cola
//                Water
//
}
