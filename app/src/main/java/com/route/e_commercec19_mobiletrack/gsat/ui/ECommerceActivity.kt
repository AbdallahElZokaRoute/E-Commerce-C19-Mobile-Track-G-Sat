package com.route.e_commercec19_mobiletrack.gsat.ui

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
import com.route.e_commercec19_mobiletrack.gsat.ui.home.HomeScreen
import com.route.e_commercec19_mobiletrack.gsat.ui.navigation.AppDestinations
import com.route.e_commercec19_mobiletrack.gsat.ui.ui.theme.ECommerceTheme

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
                        startDestination = _root_ide_package_.com.route.e_commercec19_mobiletrack.gsat.ui.navigation.AppDestinations.Main.Home
                    ) {
                        composable<AppDestinations.Main.Home> {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}
