package com.ui.saboresdeldia.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ui.saboresdeldia.data.RecipeRepository
import com.ui.saboresdeldia.ui.components.RecipeCard

@Composable
fun RecipeListScreen() {
    val recipes = RecipeRepository.getRecipes()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(recipes) { recipe ->
            RecipeCard(recipe)
        }
    }
}
