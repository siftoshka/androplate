package com.androplate.core.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream


fun Bitmap.encodeToString(): String? {
    return Base64.encodeToString(ByteArrayOutputStream().apply {
        this@encodeToString.compress(Bitmap.CompressFormat.JPEG, 100, this)
    }.toByteArray(), Base64.NO_WRAP)
}

fun Bitmap.encodeBitmapToString(): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
    val byteArray = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(byteArray, Base64.DEFAULT)
}

fun String.decodeToBitmap(): Bitmap? {
    val imageBytes = Base64.decode(this, 0)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}