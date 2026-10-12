package com.route.e_commercec19_mobiletrack.gsat.presentation.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object AppDestinations {
    @Serializable
    object Auth {
        @Serializable
        object Login

        @Serializable
        object Registration
    }

    object Main {
        @Serializable
        object Home

        @Serializable
        class ProductsList(val categoryId: String?)
    }
}
