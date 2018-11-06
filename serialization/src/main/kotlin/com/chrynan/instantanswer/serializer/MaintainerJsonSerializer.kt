@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.Meta
import com.chrynan.instantanswer.fields.MaintainerFields
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@Serializer(forClass = Meta.Maintainer::class)
object MaintainerJsonSerializer : KSerializer<Meta.Maintainer>,
    SerializationStrategy<Meta.Maintainer>,
    DeserializationStrategy<Meta.Maintainer> {

    override fun serialize(output: Encoder, obj: Meta.Maintainer) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonOutput = JsonObject(
            content = mapOf(
                MaintainerFields.GITHUB to JsonPrimitive(obj.github)
            )
        )

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): Meta.Maintainer {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val github = jsonObject.getPrimitiveOrNull(MaintainerFields.GITHUB)?.contentOrNull

        return Meta.Maintainer(github = github)
    }
}