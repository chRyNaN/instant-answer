package com.chrynan.instantanswer

import kotlinx.serialization.*

@Serializer(forClass = Result::class)
class ResultSerializer : KSerializer<Result>,
    SerializationStrategy<Result>,
    DeserializationStrategy<Result> {

    override fun deserialize(input: Decoder): Result = try {
        input.decodeSerializableValue(Result.TopicResult.serializer())
    } catch (e: Exception) {
        input.decodeSerializableValue(Result.NestedResult.serializer())
    }

    override fun serialize(output: Encoder, obj: Result) {
        when (obj) {
            is Result.TopicResult -> output.encodeSerializableValue(Result.TopicResult.serializer(), obj)
            is Result.NestedResult -> output.encodeSerializableValue(Result.NestedResult.serializer(), obj)
        }
    }
}