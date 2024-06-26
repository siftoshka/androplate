package com.androplate.core.extensions


/**
 * This extension function is responsible to check if list position is bigger than list size to
 * eliminate indexoutofbounds exception
 */
fun <E> List<E>.getIfExists(position: Int): E? {
    return if (position in indices)
        get(position)
    else
        null
}

/**
 * This extension function is responsible to check if list position is bigger than list size to
 * eliminate indexoutofbounds exception
 */
fun <E> Array<E>.getIfExists(position: Int): E? {
    return if (position in indices)
        get(position)
    else
        null
}

fun <E> ArrayList<E>.convertLongArrayListToLongArray(): LongArray {
    val durations = LongArray(this.size)
    for ((index, item) in this.withIndex()){
        durations[index] = item as Long
    }
    return durations
}
