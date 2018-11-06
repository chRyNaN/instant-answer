@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.Meta
import com.chrynan.instantanswer.fields.SourceOptionsFields
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@Serializer(forClass = Meta.SourceOptions::class)
object SourceOptionsJsonSerializer : KSerializer<Meta.SourceOptions>,
    SerializationStrategy<Meta.SourceOptions>,
    DeserializationStrategy<Meta.SourceOptions> {

    override fun serialize(output: Encoder, obj: Meta.SourceOptions) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonOutput = JsonObject(
            content = mapOf(
                SourceOptionsFields.DIRECTORY to JsonPrimitive(obj.directory),
                SourceOptionsFields.IS_FANON to JsonPrimitive(obj.isFanon),
                SourceOptionsFields.IS_MEDIA_WIKI to JsonPrimitive(obj.isMediaWiki),
                SourceOptionsFields.IS_WIKIPEDIA to JsonPrimitive(obj.isWikipedia),
                SourceOptionsFields.LANGUAGE to JsonPrimitive(obj.language),
                SourceOptionsFields.MIN_ABSTRACT_LENGTH to JsonPrimitive(obj.minAbstractLength),
                SourceOptionsFields.SKIP_ABSTRACT to JsonPrimitive(obj.skipAbstract),
                SourceOptionsFields.SKIP_ABSTRACT_PAREN to JsonPrimitive(obj.skipAbstractParen),
                SourceOptionsFields.SKIP_END to JsonPrimitive(obj.skipEnd),
                SourceOptionsFields.SKIP_ICON to JsonPrimitive(obj.skipIcon),
                SourceOptionsFields.SKIP_IMAGE_NAME to JsonPrimitive(obj.skipImageName),
                SourceOptionsFields.SKIP_QR to JsonPrimitive(obj.skipQr),
                SourceOptionsFields.SOURCE_INFO to JsonPrimitive(obj.sourceInfo),
                SourceOptionsFields.SOURCE_SKIP to JsonPrimitive(obj.sourceSkip)
            )
        )

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): Meta.SourceOptions {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val directory = jsonObject.getPrimitiveOrNull(SourceOptionsFields.DIRECTORY)?.contentOrNull
        val isFanon = jsonObject.getPrimitiveOrNull(SourceOptionsFields.IS_FANON)?.booleanOrNull
        val isMediaWiki = jsonObject.getPrimitiveOrNull(SourceOptionsFields.IS_MEDIA_WIKI)?.booleanOrNull
        val isWikipedia = jsonObject.getPrimitiveOrNull(SourceOptionsFields.IS_WIKIPEDIA)?.booleanOrNull
        val language = jsonObject.getPrimitiveOrNull(SourceOptionsFields.LANGUAGE)?.contentOrNull
        val minAbstractLength = jsonObject.getPrimitiveOrNull(SourceOptionsFields.MIN_ABSTRACT_LENGTH)?.contentOrNull
        val skipAbstract = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SKIP_ABSTRACT)?.booleanOrNull
        val skipAbstractParen = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SKIP_ABSTRACT_PAREN)?.booleanOrNull
        val skipEnd = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SKIP_END)?.booleanOrNull
        val skipIcon = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SKIP_ICON)?.booleanOrNull
        val skipImageName = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SKIP_IMAGE_NAME)?.booleanOrNull
        val skipQr = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SKIP_QR)?.contentOrNull
        val sourceInfo = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SOURCE_INFO)?.contentOrNull
        val sourceSkip = jsonObject.getPrimitiveOrNull(SourceOptionsFields.SOURCE_SKIP)?.contentOrNull

        return Meta.SourceOptions(
            directory = directory,
            isFanon = isFanon,
            isMediaWiki = isMediaWiki,
            isWikipedia = isWikipedia,
            language = language,
            minAbstractLength = minAbstractLength,
            skipAbstract = skipAbstract,
            skipAbstractParen = skipAbstractParen,
            skipEnd = skipEnd,
            skipIcon = skipIcon,
            skipImageName = skipImageName,
            skipQr = skipQr,
            sourceInfo = sourceInfo,
            sourceSkip = sourceSkip
        )
    }
}