package com.ui.saboresdeldia

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ui.saboresdeldia.ui.screens.RecipeListScreen
import com.ui.saboresdeldia.ui.theme.SaboresDelDiaTheme

@Preview(name = "Modo Claro", showBackground = true)
@Composable
fun LightPreview() {
    SaboresDelDiaTheme(darkTheme = false) {
        RecipeListScreen()
    }
}

@Preview(name = "Modo Oscuro", showBackground = true)
@Composable
fun DarkPreview() {
    SaboresDelDiaTheme(darkTheme = true) {
        RecipeListScreen()
    }
}
