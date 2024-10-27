package com.boomslang.firebasetestapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val products = productRepository.fetchProducts()
                _products.value = products
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Error fetching products", e)
            }

        }
    }

    fun getProductByName(productName: String): Product? {
        return _products.value?.find { it.name == productName }
    }
}