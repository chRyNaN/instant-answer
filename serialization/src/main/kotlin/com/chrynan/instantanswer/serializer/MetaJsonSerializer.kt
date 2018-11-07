@file:Suppress("unused")

package com.chrynan.instantanswer.serializer

import com.chrynan.instantanswer.Meta
import com.chrynan.instantanswer.fields.MetaFields
import kotlinx.serialization.*
import kotlinx.serialization.json.*

object MetaJsonSerializer : KSerializer<Meta>,
    SerializationStrategy<Meta>,
    DeserializationStrategy<Meta> {

    override val descriptor: SerialDescriptor
        get() = throw SerializationException("SerialDescriptor is not implemented for ${this::class}.")

    override fun serialize(output: Encoder, obj: Meta) {
        val jsonWriter =
            output as? JSON.JsonOutput ?: throw SerializationException("This class can be saved only by JSON.")

        val jsonTreeMapper = JsonTreeMapper()

        val jsonOutput = JsonObject(
            content = mapOf(
                MetaFields.BLOCK_GROUP to JsonPrimitive(obj.blockGroup),
                MetaFields.SOURCE_ID to JsonPrimitive(obj.sourceId),
                MetaFields.STATUS to JsonPrimitive(obj.status),
                MetaFields.DESIGNER to JsonPrimitive(obj.designer),
                MetaFields.DESCRIPTION to JsonPrimitive(obj.description),
                MetaFields.LIVE_DATE to JsonPrimitive(obj.liveDate),
                MetaFields.IS_STACK_EXCHANGE to JsonPrimitive(obj.isStackExchange),
                MetaFields.SOURCE_DOMAIN to JsonPrimitive(obj.sourceDomain),
                MetaFields.TAB to JsonPrimitive(obj.tab),
                MetaFields.SOURCE_URL to JsonPrimitive(obj.sourceUrl),
                MetaFields.UNSAFE to JsonPrimitive(obj.unsafe),
                MetaFields.PERL_MODULE to JsonPrimitive(obj.perlModule),
                MetaFields.CREATED_DATE to JsonPrimitive(obj.createdDate),
                MetaFields.PRODUCTION_STATE to JsonPrimitive(obj.productionState),
                MetaFields.EXAMPLE_QUERY to JsonPrimitive(obj.exampleQuery),
                MetaFields.PRODUCER to JsonPrimitive(obj.producer),
                MetaFields.SOURCE_NAME to JsonPrimitive(obj.sourceName),
                MetaFields.DEV_DATE to JsonPrimitive(obj.devDate),
                MetaFields.REPO to JsonPrimitive(obj.repo),
                MetaFields.NAME to JsonPrimitive(obj.name),
                MetaFields.JS_CALLBACK_NAME to JsonPrimitive(obj.jsCallbackName),
                MetaFields.ID to JsonPrimitive(obj.id),
                MetaFields.ATTRIBUTION to JsonPrimitive(obj.attribution),
                MetaFields.DEV_MILESTONE to JsonPrimitive(obj.devMilestone),
                MetaFields.SIGNAL_FROM to JsonPrimitive(obj.signalFrom),
                MetaFields.TOPICS to JsonArray(obj.topics.map { JsonPrimitive(it) }),
                MetaFields.DEVELOPERS to JsonArray(obj.developers.map {
                    jsonTreeMapper.writeTree(
                        it,
                        DeveloperJsonSerializer
                    )
                }),
                MetaFields.MAINTAINER to (obj.maintainer?.let { jsonTreeMapper.writeTree(it, MaintainerJsonSerializer) }
                    ?: JsonNull),
                MetaFields.SOURCE_OPTIONS to (obj.sourceOptions?.let {
                    jsonTreeMapper.writeTree(
                        it,
                        SourceOptionsJsonSerializer
                    )
                } ?: JsonNull)
            )
        )

        jsonWriter.writeTree(jsonOutput)
    }

    override fun deserialize(input: Decoder): Meta {
        val json = input as? JSON.JsonInput ?: throw SerializationException("This class can be loaded only by JSON.")

        val jsonObject = json.readAsTree() as? JsonObject ?: throw SerializationException("Expected JSON object.")

        val jsonTreeMapper = JsonTreeMapper()

        val blockGroup = jsonObject.getPrimitiveOrNull(MetaFields.BLOCK_GROUP)?.contentOrNull
        val sourceId = jsonObject.getPrimitiveOrNull(MetaFields.SOURCE_ID)?.intOrNull
        val status = jsonObject.getPrimitiveOrNull(MetaFields.STATUS)?.contentOrNull
        val designer = jsonObject.getPrimitiveOrNull(MetaFields.DESIGNER)?.contentOrNull
        val description = jsonObject.getPrimitiveOrNull(MetaFields.DESCRIPTION)?.contentOrNull
        val liveDate = jsonObject.getPrimitiveOrNull(MetaFields.LIVE_DATE)?.longOrNull
        val isStackExchange = jsonObject.getPrimitiveOrNull(MetaFields.IS_STACK_EXCHANGE)?.booleanOrNull
        val sourceDomain = jsonObject.getPrimitiveOrNull(MetaFields.SOURCE_DOMAIN)?.contentOrNull
        val tab = jsonObject.getPrimitiveOrNull(MetaFields.TAB)?.contentOrNull
        val sourceUrl = jsonObject.getPrimitiveOrNull(MetaFields.SOURCE_URL)?.contentOrNull
        val unsafe = jsonObject.getPrimitiveOrNull(MetaFields.UNSAFE)?.intOrNull
        val perlModule = jsonObject.getPrimitiveOrNull(MetaFields.PERL_MODULE)?.contentOrNull
        val createdDate = jsonObject.getPrimitiveOrNull(MetaFields.CREATED_DATE)?.longOrNull
        val productionState = jsonObject.getPrimitiveOrNull(MetaFields.PRODUCTION_STATE)?.contentOrNull
        val exampleQuery = jsonObject.getPrimitiveOrNull(MetaFields.EXAMPLE_QUERY)?.contentOrNull
        val producer = jsonObject.getPrimitiveOrNull(MetaFields.PRODUCER)?.contentOrNull
        val sourceName = jsonObject.getPrimitiveOrNull(MetaFields.SOURCE_NAME)?.contentOrNull
        val devDate = jsonObject.getPrimitiveOrNull(MetaFields.DEV_DATE)?.longOrNull
        val repo = jsonObject.getPrimitiveOrNull(MetaFields.REPO)?.contentOrNull
        val name = jsonObject.getPrimitiveOrNull(MetaFields.NAME)?.contentOrNull
        val jsCallbackName = jsonObject.getPrimitiveOrNull(MetaFields.JS_CALLBACK_NAME)?.contentOrNull
        val id = jsonObject.getPrimitiveOrNull(MetaFields.ID)?.contentOrNull
        val attribution = jsonObject.getPrimitiveOrNull(MetaFields.ATTRIBUTION)?.contentOrNull
        val devMilestone = jsonObject.getPrimitiveOrNull(MetaFields.DEV_MILESTONE)?.contentOrNull
        val signalFrom = jsonObject.getPrimitiveOrNull(MetaFields.SIGNAL_FROM)?.contentOrNull
        val topics = jsonObject.getArrayOrNull(MetaFields.TOPICS)?.content?.map { it.content } ?: emptyList()
        val developers = jsonObject.getArrayOrNull(MetaFields.DEVELOPERS)?.content?.map {
            jsonTreeMapper.readTree(
                it,
                DeveloperJsonSerializer
            )
        } ?: emptyList()
        val maintainer = jsonObject.getObjectOrNull(MetaFields.MAINTAINER)
            ?.let { jsonTreeMapper.readTree(it, MaintainerJsonSerializer) }
        val sourceOptions = jsonObject.getObjectOrNull(MetaFields.SOURCE_OPTIONS)
            ?.let { jsonTreeMapper.readTree(it, SourceOptionsJsonSerializer) }

        return Meta(
            blockGroup = blockGroup,
            sourceId = sourceId,
            status = status,
            designer = designer,
            description = description,
            liveDate = liveDate,
            isStackExchange = isStackExchange,
            sourceDomain = sourceDomain,
            tab = tab,
            sourceUrl = sourceUrl,
            unsafe = unsafe,
            perlModule = perlModule,
            createdDate = createdDate,
            productionState = productionState,
            exampleQuery = exampleQuery,
            producer = producer,
            sourceName = sourceName,
            devDate = devDate,
            repo = repo,
            name = name,
            jsCallbackName = jsCallbackName,
            id = id,
            attribution = attribution,
            devMilestone = devMilestone,
            signalFrom = signalFrom,
            topics = topics,
            developers = developers,
            maintainer = maintainer,
            sourceOptions = sourceOptions
        )
    }
}