package com.androplate.domain.base

interface BaseValidator<T> {
    fun isValid(input: T): Boolean
}