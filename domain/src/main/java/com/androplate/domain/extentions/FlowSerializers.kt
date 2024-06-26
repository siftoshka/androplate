package com.androplate.domain.extentions

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class MutableStateFlowSerializer<T>(private val dataSerializer: KSerializer<T>) : KSerializer<MutableStateFlow<T>> {
    override val descriptor: SerialDescriptor = dataSerializer.descriptor
    override fun serialize(encoder: Encoder, value: MutableStateFlow<T>) = dataSerializer.serialize(encoder, value.value)
    override fun deserialize(decoder: Decoder) = MutableStateFlow(dataSerializer.deserialize(decoder))
}

/**
 * Not supports create of correct flow, because we dnt know capacity and strategy of shared flow, use carefully
 */

class MutableSharedFlowSerializer<T>(private val dataSerializer: KSerializer<T>) : KSerializer<MutableSharedFlow<T>> {
    override val descriptor: SerialDescriptor = dataSerializer.descriptor
    override fun serialize(encoder: Encoder, value: MutableSharedFlow<T>) {
        val lastValue = value.replayCache.first()
        return dataSerializer.serialize(encoder, lastValue)
    }
    override fun deserialize(decoder: Decoder): MutableSharedFlow<T> {
        val flow = produceSharedFlow<T>()
        runBlocking { flow.emit(dataSerializer.deserialize(decoder)) }
        return flow
    }
}