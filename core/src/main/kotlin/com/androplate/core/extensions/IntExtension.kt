package com.androplate.core.extensions

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import androidx.core.content.ContextCompat

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Int.elevation: Float
    get() = (this * Resources.getSystem().displayMetrics.density)


fun Int.asColorResource(context: Context) = ContextCompat.getColor(context, this)

fun Int.asDrawableResource(context: Context) = ContextCompat.getDrawable(context, this)

fun Int.asDimenResource(context: Context) = context.resources.getDimension(this)

fun Int.dpToPx(resource: Resources): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        resource.displayMetrics
    ).toInt()
}
