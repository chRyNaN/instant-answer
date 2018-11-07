@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.InstantAnswer
import com.chrynan.instantanswer.fields.InstantAnswerFields
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializer(forClass = InstantAnswer::class)
object InstantAnswerJsonSerializer : KSerializer<InstantAnswer>,
    SerializationStrategy<InstantAnswer>,
    DeserializationStrategy<InstantAnswer> {

    override fun serialize(output: Encoder, obj: InstantAnswer) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonTreeMapper = JsonTreeMapper()

        val jsonOutput = JsonObject(
            content = mapOf(
                InstantAnswerFields.ABSTRACT to JsonPrimitive(obj.abstract),
                InstantAnswerFields.ABSTRACT_TEXT to JsonPrimitive(obj.abstractText),
                InstantAnswerFields.DEFINITION_URL to JsonPrimitive(obj.definitionUrl),
                InstantAnswerFields.IMAGE_IS_LOGO to JsonPrimitive(obj.imageIsLogo),
                InstantAnswerFields.ENTITY to JsonPrimitive(obj.entity),
                InstantAnswerFields.DEFINITION_SOURCE to JsonPrimitive(obj.definitionSource),
                InstantAnswerFields.HEADING to JsonPrimitive(obj.heading),
                InstantAnswerFields.INFO_BOX to JsonPrimitive(obj.infoBox),
                InstantAnswerFields.IMAGE to JsonPrimitive(obj.image),
                InstantAnswerFields.ABSTRACT_URL to JsonPrimitive(obj.abstractUrl),
                InstantAnswerFields.ANSWER_TYPE to JsonPrimitive(obj.answerType),
                InstantAnswerFields.TYPE to JsonPrimitive(obj.type),
                InstantAnswerFields.REDIRECT_URL to JsonPrimitive(obj.redirectUrl),
                InstantAnswerFields.DEFINITION to JsonPrimitive(obj.definition),
                InstantAnswerFields.IMAGE_WIDTH to JsonPrimitive(obj.imageWidth),
                InstantAnswerFields.IMAGE_HEIGHT to JsonPrimitive(obj.imageHeight),
                InstantAnswerFields.ANSWER to JsonPrimitive(obj.answer),
                InstantAnswerFields.ABSTRACT_SOURCE to JsonPrimitive(obj.abstractSource),
                InstantAnswerFields.ABSTRACT_IMAGE_URL to JsonPrimitive(obj.abstractImageUrl),
                InstantAnswerFields.ABSTRACT_TOPIC to JsonPrimitive(obj.abstractTopic),
                InstantAnswerFields.RESULTS to JsonArray(obj.results.map {
                    jsonTreeMapper.writeTree(
                        it,
                        ResultJsonSerializer
                    )
                }),
                InstantAnswerFields.RELATED_TOPICS to JsonArray(obj.relatedTopics.map {
                    jsonTreeMapper.writeTree(
                        it,
                        ResultJsonSerializer
                    )
                }),
                InstantAnswerFields.META to (obj.meta?.let { jsonTreeMapper.writeTree(it, MetaJsonSerializer) }
                    ?: JsonNull)
            )
        )

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): InstantAnswer {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val jsonTreeMapper = JsonTreeMapper()

        val abstract = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ABSTRACT)?.contentOrNull
        val abstractText = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ABSTRACT_TEXT)?.contentOrNull
        val definitionUrl = jsonObject.getPrimitiveOrNull(InstantAnswerFields.DEFINITION_URL)?.contentOrNull
        val imageIsLogo = jsonObject.getPrimitiveOrNull(InstantAnswerFields.IMAGE_IS_LOGO)?.booleanOrNull
        val entity = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ENTITY)?.contentOrNull
        val definitionSource = jsonObject.getPrimitiveOrNull(InstantAnswerFields.DEFINITION_SOURCE)?.contentOrNull
        val heading = jsonObject.getPrimitiveOrNull(InstantAnswerFields.HEADING)?.contentOrNull
        val infoBox = jsonObject.getPrimitiveOrNull(InstantAnswerFields.INFO_BOX)?.contentOrNull
        val image = jsonObject.getPrimitiveOrNull(InstantAnswerFields.IMAGE)?.contentOrNull
        val abstractUrl = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ABSTRACT_URL)?.contentOrNull
        val answerType = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ANSWER_TYPE)?.contentOrNull
        val type = jsonObject.getPrimitiveOrNull(InstantAnswerFields.TYPE)?.contentOrNull
        val redirectUrl = jsonObject.getPrimitiveOrNull(InstantAnswerFields.REDIRECT_URL)?.contentOrNull
        val definition = jsonObject.getPrimitiveOrNull(InstantAnswerFields.DEFINITION)?.contentOrNull
        val imageWidth = jsonObject.getPrimitiveOrNull(InstantAnswerFields.IMAGE_WIDTH)?.intOrNull
        val imageHeight = jsonObject.getPrimitiveOrNull(InstantAnswerFields.IMAGE_HEIGHT)?.intOrNull
        val answer = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ANSWER)?.contentOrNull
        val abstractSource = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ABSTRACT_SOURCE)?.contentOrNull
        val abstractImageUrl = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ABSTRACT_IMAGE_URL)?.contentOrNull
        val abstractTopic = jsonObject.getPrimitiveOrNull(InstantAnswerFields.ABSTRACT_TOPIC)?.contentOrNull
        val meta = jsonObject.getObjectOrNull(InstantAnswerFields.META)
            ?.let { jsonTreeMapper.readTree(it, MetaJsonSerializer) }
        val results = jsonObject.getArrayOrNull(InstantAnswerFields.RESULTS)?.content?.map {
            jsonTreeMapper.readTree(
                it,
                ResultJsonSerializer
            )
        } ?: emptyList()
        val relatedTopics = jsonObject.getArrayOrNull(InstantAnswerFields.RELATED_TOPICS)?.content?.map {
            jsonTreeMapper.readTree(
                it,
                ResultJsonSerializer
            )
        } ?: emptyList()

        return InstantAnswer(
            abstract = abstract,
            abstractText = abstractText,
            definitionUrl = definitionUrl,
            imageIsLogo = imageIsLogo,
            entity = entity,
            definitionSource = definitionSource,
            heading = heading,
            infoBox = infoBox,
            image = image,
            abstractUrl = abstractUrl,
            answerType = answerType,
            type = type,
            redirectUrl = redirectUrl,
            definition = definition,
            imageWidth = imageWidth,
            imageHeight = imageHeight,
            answer = answer,
            abstractSource = abstractSource,
            abstractImageUrl = abstractImageUrl,
            abstractTopic = abstractTopic,
            meta = meta,
            results = results,
            relatedTopics = relatedTopics
        )
    }
}