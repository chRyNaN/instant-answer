@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.Result
import com.chrynan.instantanswer.fields.ResultFields
import kotlinx.serialization.*
import kotlinx.serialization.json.*

object ResultJsonSerializer : KSerializer<Result>,
    SerializationStrategy<Result>,
    DeserializationStrategy<Result> {

    override val descriptor: SerialDescriptor
        get() = throw SerializationException("SerialDescriptor is not implemented for ${this::class}.")

    override fun serialize(output: Encoder, obj: Result) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonTreeMapper = JsonTreeMapper()

        val contentMap = when (obj) {
            is Result.TopicResult -> mapOf(
                ResultFields.HTML_FORMATTED_TEXT to JsonPrimitive(obj.htmlFormattedText),
                ResultFields.TEXT to JsonPrimitive(obj.text),
                ResultFields.URL to JsonPrimitive(obj.url),
                ResultFields.WEB_ICON to (obj.webIcon?.let { jsonTreeMapper.writeTree(it, WebIconJsonSerializer) }
                    ?: JsonNull)
            )
            is Result.NestedResult -> mapOf(
                ResultFields.NAME to JsonPrimitive(obj.name),
                ResultFields.TOPICS to JsonArray(obj.topics.map { jsonTreeMapper.writeTree(it, this) })
            )
            else -> emptyMap()
        }

        val jsonOutput = JsonObject(content = contentMap)

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): Result {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val htmlFormattedText = jsonObject.getPrimitiveOrNull(ResultFields.HTML_FORMATTED_TEXT)?.contentOrNull
        val text = jsonObject.getPrimitiveOrNull(ResultFields.TEXT)?.contentOrNull
        val url = jsonObject.getPrimitiveOrNull(ResultFields.URL)?.contentOrNull
        val name = jsonObject.getPrimitiveOrNull(ResultFields.NAME)?.contentOrNull
        val webIconJsonObject = jsonObject.getObjectOrNull(ResultFields.WEB_ICON)
        val topicsJsonArray = jsonObject.getArrayOrNull(ResultFields.TOPICS)?.content

        val jsonTreeMapper = JsonTreeMapper()

        val webIcon = if (webIconJsonObject != null) jsonTreeMapper.readTree(
            webIconJsonObject,
            WebIconJsonSerializer
        ) else null

        val topics = topicsJsonArray?.map { jsonTreeMapper.readTree(it, this) }

        return if (name != null && topics != null) {
            Result.NestedResult(name = name, topics = topics)
        } else {
            Result.TopicResult(webIcon = webIcon, url = url, text = text, htmlFormattedText = htmlFormattedText)
        }
    }
}