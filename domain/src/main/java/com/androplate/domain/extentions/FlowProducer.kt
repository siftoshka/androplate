package com.androplate.domain.extentions

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> produceSharedFlow(replay: Int = 1, extraBufferCapacity: Int = 0, bufferOverflow: BufferOverflow = BufferOverflow.DROP_OLDEST) =
    MutableSharedFlow<T>(replay = replay, extraBufferCapacity = extraBufferCapacity, onBufferOverflow = bufferOverflow)

fun <T> produceChannel(capacity: Int = 1, bufferOverflow: BufferOverflow = BufferOverflow.DROP_OLDEST, onUndeliveredElement: ((T) -> Unit)? = null) =
    Channel<T>(capacity = capacity, onBufferOverflow = bufferOverflow, onUndeliveredElement = onUndeliveredElement)