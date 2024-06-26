package com.androplate.core.extensions

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

@ChecksSdkIntAtLeast(parameter = 0)
fun isVersionHigherAndEqual(version: Int): Boolean {
    return Build.VERSION.SDK_INT >= version
}

@ChecksSdkIntAtLeast(parameter = 0)
fun isVersionHigher(version: Int): Boolean {
    return Build.VERSION.SDK_INT > version
}

fun isVersionLowerAndEqual(version: Int): Boolean {
    return Build.VERSION.SDK_INT <= version
}

fun isVersionLower(version: Int): Boolean {
    return Build.VERSION.SDK_INT < version
}