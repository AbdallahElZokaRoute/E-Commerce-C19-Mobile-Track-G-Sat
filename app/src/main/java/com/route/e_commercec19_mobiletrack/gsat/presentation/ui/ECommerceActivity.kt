package com.route.e_commercec19_mobiletrack.gsat.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.route.e_commercec19_mobiletrack.gsat.presentation.ui.home.HomeScreen
import com.route.e_commercec19_mobiletrack.gsat.presentation.ui.navigation.AppDestinations
import com.route.e_commercec19_mobiletrack.gsat.presentation.ui.product.ProductsScreen
import com.route.e_commercec19_mobiletrack.gsat.presentation.ui.ui.theme.ECommerceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ECommerceActivity : ComponentActivity() {
    // Activity Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { //   runApp
            ECommerceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Navigation Component
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = AppDestinations.Main.Home
                    ) {
                        composable<AppDestinations.Main.Home> {
                            HomeScreen()
                        }
                        composable<AppDestinations.Main.ProductsList> {
                            val params = it.toRoute<AppDestinations.Main.ProductsList>()
                            ProductsScreen(categoryId = params.categoryId)
                        }
                    }
                }
            }
        }
    }
}
