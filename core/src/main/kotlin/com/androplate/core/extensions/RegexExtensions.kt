package com.androplate.core.extensions

import androidx.core.util.PatternsCompat

fun CharSequence?.isValidEmail(): Boolean =
    !isNullOrEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()
