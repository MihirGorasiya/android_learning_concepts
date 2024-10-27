package com.boomslang.firebasetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boomslang.firebasetestapp.ui.theme.FirebaseTestAppTheme
import com.google.firebase.Firebase
import com.google.firebase.initialize

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Firebase.initialize(this)
        enableEdgeToEdge()
        setContent {
            FirebaseTestAppTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Constants.HOME_ROUTE) {
                    composable(Constants.HOME_ROUTE) {
                        App(navController)
                    }
                    composable("${Constants.PRODUCT_ROUTE}/{productName}") { backstackEntry ->


                        val productRepository: ProductRepository = remember { ProductRepository() }
                        val viewModel: ProductViewModel =
                            viewModel(factory = ViewModelFactory(productRepository))
                        val products by viewModel.products.observeAsState(emptyList())

                        val productName = backstackEntry.arguments?.getString("productName")

                        if (products.isNotEmpty() && productName != null) {
                            val product = viewModel.getProductByName(productName)

                            if (product != null) {
                                ProductPage(navController, product)
                            } else {
                                println("Product not found")
                            }
                        } else {
                            println("Loading Products...")
                        }
                    }
                }
            }
        }
    }
}
