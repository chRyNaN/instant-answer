@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.Meta
import com.chrynan.instantanswer.fields.DeveloperFields
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@Serializer(forClass = Meta.Developer::class)
object DeveloperJsonSerializer : KSerializer<Meta.Developer>,
    SerializationStrategy<Meta.Developer>,
    DeserializationStrategy<Meta.Developer> {

    override fun serialize(output: Encoder, obj: Meta.Developer) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonOutput = JsonObject(
            content = mapOf(
                DeveloperFields.URL to JsonPrimitive(obj.url),
                DeveloperFields.NAME to JsonPrimitive(obj.name),
                DeveloperFields.TYPE to JsonPrimitive(obj.type)
            )
        )

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): Meta.Developer {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val url = jsonObject.getPrimitiveOrNull(DeveloperFields.URL)?.contentOrNull
        val name = jsonObject.getPrimitiveOrNull(DeveloperFields.NAME)?.contentOrNull
        val type = jsonObject.getPrimitiveOrNull(DeveloperFields.TYPE)?.contentOrNull

        return Meta.Developer(url = url, name = name, type = type)
    }
}