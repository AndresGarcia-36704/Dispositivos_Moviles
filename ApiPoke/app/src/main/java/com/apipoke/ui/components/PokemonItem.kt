package com.apipoke.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun PokemonItem(name: String, imageUrl: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = name,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = name.uppercase(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}