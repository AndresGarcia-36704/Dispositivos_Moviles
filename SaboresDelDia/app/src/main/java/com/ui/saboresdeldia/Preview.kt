package com.ui.saboresdeldia

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ui.saboresdeldia.data.RecipeRepository
import com.ui.saboresdeldia.ui.components.RecipeCard
import com.ui.saboresdeldia.ui.theme.SaboresDelDiaTheme

@Preview(name = "LightPreview - Modo Claro", showBackground = true)
@Composable
fun LightPreview() {
    SaboresDelDiaTheme(darkTheme = false) {
        PreviewContent()
    }
}

@Preview(name = "DarkPreview - Modo Oscuro", showBackground = true)
@Composable
fun DarkPreview() {
    SaboresDelDiaTheme(darkTheme = true) {
        PreviewContent()
    }
}

@Composable
private fun PreviewContent() {
    val recipes = RecipeRepository.getRecipes()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            recipes.forEach { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}
