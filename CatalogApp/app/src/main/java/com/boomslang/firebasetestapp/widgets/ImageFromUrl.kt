package com.boomslang.firebasetestapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageFromUrl(
    imageUrl: String,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
) {
    val painter = rememberAsyncImagePainter(model = imageUrl)

    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
    )
}