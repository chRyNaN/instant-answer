@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.WebIcon
import com.chrynan.instantanswer.fields.WebIconFields
import com.chrynan.instantanswer.fields.WebIconFields.HEIGHT
import com.chrynan.instantanswer.fields.WebIconFields.URL
import com.chrynan.instantanswer.fields.WebIconFields.WIDTH
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

object WebIconJsonSerializer : KSerializer<WebIcon>,
    SerializationStrategy<WebIcon>,
    DeserializationStrategy<WebIcon> {

    override val descriptor: SerialDescriptor
        get() = throw SerializationException("SerialDescriptor is not implemented for ${this::class}.")

    override fun serialize(output: Encoder, obj: WebIcon) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonOutput = JsonObject(
            content = mapOf(
                WebIconFields.URL to JsonPrimitive(obj.url),
                WebIconFields.HEIGHT to JsonPrimitive(obj.height),
                WebIconFields.WIDTH to JsonPrimitive(obj.width)
            )
        )

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): WebIcon {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val url = jsonObject.getPrimitiveOrNull(URL)?.contentOrNull
        val height = jsonObject.getPrimitiveOrNull(HEIGHT)?.contentOrNull?.toIntOrNull()
        val width = jsonObject.getPrimitiveOrNull(WIDTH)?.contentOrNull?.toIntOrNull()

        return WebIcon(url = url, height = height, width = width)
    }
}