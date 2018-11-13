@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.InstantAnswer
import com.chrynan.instantanswer.api.Meta
import com.chrynan.instantanswer.api.Result
import com.chrynan.instantanswer.fields.InstantAnswerFields.ABSTRACT
import com.chrynan.instantanswer.fields.InstantAnswerFields.ABSTRACT_IMAGE_URL
import com.chrynan.instantanswer.fields.InstantAnswerFields.ABSTRACT_SOURCE
import com.chrynan.instantanswer.fields.InstantAnswerFields.ABSTRACT_TEXT
import com.chrynan.instantanswer.fields.InstantAnswerFields.ABSTRACT_TOPIC
import com.chrynan.instantanswer.fields.InstantAnswerFields.ABSTRACT_URL
import com.chrynan.instantanswer.fields.InstantAnswerFields.ANSWER
import com.chrynan.instantanswer.fields.InstantAnswerFields.ANSWER_TYPE
import com.chrynan.instantanswer.fields.InstantAnswerFields.DEFINITION
import com.chrynan.instantanswer.fields.InstantAnswerFields.DEFINITION_SOURCE
import com.chrynan.instantanswer.fields.InstantAnswerFields.DEFINITION_URL
import com.chrynan.instantanswer.fields.InstantAnswerFields.ENTITY
import com.chrynan.instantanswer.fields.InstantAnswerFields.HEADING
import com.chrynan.instantanswer.fields.InstantAnswerFields.IMAGE
import com.chrynan.instantanswer.fields.InstantAnswerFields.IMAGE_HEIGHT
import com.chrynan.instantanswer.fields.InstantAnswerFields.IMAGE_IS_LOGO
import com.chrynan.instantanswer.fields.InstantAnswerFields.IMAGE_WIDTH
import com.chrynan.instantanswer.fields.InstantAnswerFields.INFO_BOX
import com.chrynan.instantanswer.fields.InstantAnswerFields.META
import com.chrynan.instantanswer.fields.InstantAnswerFields.REDIRECT_URL
import com.chrynan.instantanswer.fields.InstantAnswerFields.RELATED_TOPICS
import com.chrynan.instantanswer.fields.InstantAnswerFields.RESULTS
import com.chrynan.instantanswer.fields.InstantAnswerFields.TYPE
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InstantAnswerJson(
    @field:Json(name = RESULTS) override val results: List<Result> = emptyList(),
    @field:Json(name = ABSTRACT) override val abstract: String? = null,
    @field:Json(name = ABSTRACT_TEXT) override val abstractText: String? = null,
    @field:Json(name = DEFINITION_URL) override val definitionUrl: String? = null,
    @field:Json(name = IMAGE_IS_LOGO) override val imageIsLogo: Boolean? = null,
    @field:Json(name = ENTITY) override val entity: String? = null,
    @field:Json(name = DEFINITION_SOURCE) override val definitionSource: String? = null,
    @field:Json(name = HEADING) override val heading: String? = null,
    @field:Json(name = INFO_BOX) override val infoBox: String? = null,
    @field:Json(name = IMAGE) override val image: String? = null,
    @field:Json(name = ABSTRACT_URL) override val abstractUrl: String? = null,
    @field:Json(name = ANSWER_TYPE) override val answerType: String? = null,
    @field:Json(name = META) override val meta: Meta? = null,
    @field:Json(name = RELATED_TOPICS) override val relatedTopics: List<Result> = emptyList(),
    @field:Json(name = TYPE) override val type: String? = null,
    @field:Json(name = REDIRECT_URL) override val redirectUrl: String? = null,
    @field:Json(name = DEFINITION) override val definition: String? = null,
    @field:Json(name = IMAGE_WIDTH) override val imageWidth: Int? = null,
    @field:Json(name = IMAGE_HEIGHT) override val imageHeight: Int? = null,
    @field:Json(name = ANSWER) override val answer: String? = null,
    @field:Json(name = ABSTRACT_SOURCE) override val abstractSource: String? = null,
    @field:Json(name = ABSTRACT_IMAGE_URL) override val abstractImageUrl: String? = null,
    @field:Json(name = ABSTRACT_TOPIC) override val abstractTopic: String? = null
) : InstantAnswer {

    override fun copyWith(
        results: List<Result>,
        abstract: String?,
        abstractText: String?,
        definitionUrl: String?,
        imageIsLogo: Boolean?,
        entity: String?,
        definitionSource: String?,
        heading: String?,
        infoBox: String?,
        image: String?,
        abstractUrl: String?,
        answerType: String?,
        meta: Meta?,
        relatedTopics: List<Result>,
        type: String?,
        redirectUrl: String?,
        definition: String?,
        imageWidth: Int?,
        imageHeight: Int?,
        answer: String?,
        abstractSource: String?,
        abstractImageUrl: String?,
        abstractTopic: String?
    ): InstantAnswer =
        copy(
            results = results,
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
            meta = meta,
            relatedTopics = relatedTopics,
            type = type,
            redirectUrl = redirectUrl,
            definition = definition,
            imageHeight = imageHeight,
            imageWidth = imageWidth,
            answer = answer,
            abstractSource = abstractSource,
            abstractImageUrl = abstractImageUrl,
            abstractTopic = abstractTopic
        )
}