package com.androplate.uitoolkit.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColors = darkColors(
    primary = Purple80,
    secondary = PurpleGrey80,
)

private val LightColors = lightColors(
    primary = Purple40,
    secondary = PurpleGrey40,
)

@Composable
fun AndroplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when {
        darkTheme -> DarkColors
        else -> LightColors
    }

    val palette = when {
        darkTheme -> darkPalette
        else -> lightPalette
    }

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalPalette provides palette
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            content = content
        )
    }
}