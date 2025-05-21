package com.ui.saboresdeldia.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

// Colores claros
private val LightColors = lightColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.White,
    secondary = Color(0xFFFFC107),
    onSecondary = Color.Black,
    background = Color(0xFFEDEDED),
    surface = Color(0xFFF0F0F0),
    onSurfaceVariant = Color(0xFF4E4E4E)
)

// Colores oscuros
private val DarkColors = darkColorScheme(
    primary = Color(0xFF81C784),
    onPrimary = Color.Black,
    secondary = Color(0xFFFFD54F),
    onSecondary = Color.Black,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onSurfaceVariant = Color(0xFFB0B0B0)
)

// Tipografía
private val AppTypography = Typography(
    displayLarge = TextStyle(fontSize = 32.sp, fontFamily = FontFamily.Default),
    titleLarge = TextStyle(fontSize = 22.sp, fontFamily = FontFamily.Default),
    bodyMedium = TextStyle(fontSize = 16.sp, fontFamily = FontFamily.Default),
    bodySmall = TextStyle(fontSize = 14.sp, fontFamily = FontFamily.Default),
    labelLarge = TextStyle(fontSize = 14.sp, fontFamily = FontFamily.Default),
    labelSmall = TextStyle(fontSize = 12.sp, fontFamily = FontFamily.Default)
)

@Composable
fun SaboresDelDiaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
