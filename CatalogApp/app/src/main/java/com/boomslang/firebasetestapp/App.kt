package com.boomslang.firebasetestapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boomslang.firebasetestapp.widgets.ImageFromUrl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    navController: NavController,
    productRepository: ProductRepository = remember { ProductRepository() }
) {
    val viewModel: ProductViewModel = viewModel(factory = ViewModelFactory(productRepository))
    val products by viewModel.products.observeAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Catalog App") },
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth()
                    .padding(10.dp, top = 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    if (products.isNotEmpty()) {
                        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                            items(products.size) { index ->
                                Box(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clip(RoundedCornerShape(10.dp))
//                                        .background(Color.DarkGray)
//                                        .fillMaxSize()
                                ) {
                                    Column(modifier = Modifier
                                        .padding(10.dp)
                                        .clickable {
                                            navController.navigate("${Constants.PRODUCT_ROUTE}/${products[index].name}")
                                        }) {
                                        Box(
                                            modifier = Modifier
                                                .size(170.dp, 170.dp)
                                                .padding(bottom = 10.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Color.Gray)
                                        ) {
                                            ImageFromUrl(
                                                imageUrl = products[index].imageUrl[0],
                                                modifier = Modifier.fillMaxSize(),
                                                contentScale = ContentScale.Crop,
                                            )
                                        }
                                        Text(
                                            text = products[index].price.toString(),
                                            style = TextStyle(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 16.sp
                                            ),
                                            modifier = Modifier.padding(bottom = 5.dp)
                                        )
                                        Text(
                                            text = products[index].name,
                                            style = TextStyle(
                                                fontSize = 14.sp
                                            )
                                        )
                                    }
                                }
                            }


                        }
                    } else {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }
    }
}