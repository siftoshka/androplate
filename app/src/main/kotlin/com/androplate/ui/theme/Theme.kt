package com.androplate.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

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

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}