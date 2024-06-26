package com.androplate.domain.exceptions

fun interface ErrorConverter {
    fun convert(throwable: Throwable): Throwable
}