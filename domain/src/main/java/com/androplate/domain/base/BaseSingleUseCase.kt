package com.androplate.domain.base

import com.androplate.domain.exceptions.ErrorConverter
import kotlin.coroutines.CoroutineContext

abstract class BaseSingleUseCase<P, R>(
    private val executionContext: CoroutineContext,
    private val errorConverter: ErrorConverter,
) {
    abstract operator fun invoke(params: P): R
}