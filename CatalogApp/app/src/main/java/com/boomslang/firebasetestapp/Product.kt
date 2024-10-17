package com.boomslang.firebasetestapp

data class Product(
    val category: String,
    val description: String,
    val imageUrl: List<String>,
    val name: String,
    val price: Double,
    val purchases: Int,
    val rating: Double,
    val seller: String,
    val views: Int
) {
//    constructor() : this("", "", mutableListOf<String>(), "", 0.0, 0, 0.0, "", 0)
}