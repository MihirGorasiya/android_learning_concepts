package com.boomslang.firebasetestapp

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class ProductRepository {
    private val database = FirebaseDatabase.getInstance()
    private val productRef = database.getReference("product_catalog")

    suspend fun fetchProducts(): List<Product> {
        return suspendCancellableCoroutine { continuation ->
            productRef.addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val productList = mutableListOf<Product>()
                        for (eachProducts in snapshot.children) {
                            /*
                            * val product = eachProducts.getValue(Product::class.java)
                            * product?.let {
                            *   print("product-> ${it.imageUrls}")  // Access imageUrls as a List<String>
                            *   productList.add(it)
                            * }
                            * */

                            val imageUrl = eachProducts.child("image_url").value
                            val imageUrls = mutableListOf<String>()

                            imageUrl.toString().trim('[', ']').split(",").forEach {
                                imageUrls.add(it.trim())
                            }


                            val product = Product(
                                category = eachProducts.child("category").value.toString(),
                                description = eachProducts.child("description").value.toString(),
                                imageUrl = imageUrls,
                                name = eachProducts.child("name").value.toString(),
                                price = eachProducts.child("price").value.toString().toDouble(),
                                purchases = eachProducts.child("purchases").value.toString()
                                    .toInt(),
                                rating = eachProducts.child("rating").value.toString().toDouble(),
                                seller = eachProducts.child("seller").value.toString(),
                                views = eachProducts.child("views").value.toString().toInt()
                            )
                            productList.add(product)
                        }
                        continuation.resume(productList)
                    }

                    override fun onCancelled(error: DatabaseError) {
                        continuation.resumeWithException(error.toException())
                    }
                }
            )
        }
    }
}