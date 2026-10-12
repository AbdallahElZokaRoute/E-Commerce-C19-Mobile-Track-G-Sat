package com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.extensions

import com.route.e_commercec19_mobiletrack.gsat.presentation.tutorial.Product


fun Double.toEGP(): String {
    return "$this EGP"
}

fun List<Product>.total(): Double {
    return this.sumOf { it.price ?: 0.0 }
}

//fun List<CartItem>.total(): Double = this.sumOf() { it.price ?: 0.0 }


// lib

//  pubspec.yaml

