package com.chrynan.instantanswer

import kotlinx.serialization.*

@Serializer(forClass = ResultJson::class)
class ResultSerializer : KSerializer<ResultJson>,
    SerializationStrategy<ResultJson>,
    DeserializationStrategy<ResultJson> {

    override fun deserialize(input: Decoder): ResultJson = try {
        input.decodeSerializableValue(ResultJson.TopicResultJson.serializer())
    } catch (e: Exception) {
        input.decodeSerializableValue(ResultJson.NestedResultJson.serializer())
    }

    override fun serialize(output: Encoder, obj: ResultJson) {
        when (obj) {
            is ResultJson.TopicResultJson -> output.encodeSerializableValue(ResultJson.TopicResultJson.serializer(), obj)
            is ResultJson.NestedResultJson -> output.encodeSerializableValue(ResultJson.NestedResultJson.serializer(), obj)
        }
    }
}