package com.boomslang.firebasetestapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.boomslang.firebasetestapp.widgets.ImageFromUrl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductPage(navController: NavController, product: Product) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Product Page") })
        }) {
        Box(modifier = Modifier.padding(it)) {
            Column(modifier = Modifier.padding(15.dp)) {
                Box(
                    modifier = Modifier
                        .height(400.dp)
                        .fillMaxWidth()
                ) {
                    ImageFromUrl(imageUrl = product.imageUrl[0], contentScale = ContentScale.Crop)
                }
                Text(
                    "${product.name}",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                )
                Text("${product.description}", style = TextStyle(fontSize = 15.sp))
                Text("\$${product.price}", style = TextStyle(fontSize = 25.sp))
            }
        }
    }
}