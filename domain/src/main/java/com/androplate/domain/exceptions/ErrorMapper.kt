package com.androplate.domain.exceptions

fun interface ErrorMapper {
    fun mapError(e: Throwable): Throwable
}