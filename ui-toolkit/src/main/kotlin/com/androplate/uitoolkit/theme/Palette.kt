package com.androplate.uitoolkit.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

@Immutable
data class Palette(
    val background: Color = Color.Unspecified
)

val LocalPalette = compositionLocalOf { Palette() }

val lightPalette = Palette(
    background = Color(0xFFD0BCFF)
)

val darkPalette = Palette(
    background = Color(0xFF7D5260)
)

val MaterialTheme.palette: Palette
    @Composable
    @ReadOnlyComposable
    get() = LocalPalette.current