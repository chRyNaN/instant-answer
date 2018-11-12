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
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InstantAnswerJson(
    @SerialName(RESULTS) @Optional override val results: List<Result> = emptyList(),
    @SerialName(ABSTRACT) @Optional override val abstract: String? = null,
    @SerialName(ABSTRACT_TEXT) @Optional override val abstractText: String? = null,
    @SerialName(DEFINITION_URL) @Optional override val definitionUrl: String? = null,
    @SerialName(IMAGE_IS_LOGO) @Optional override val imageIsLogo: Boolean? = null,
    @SerialName(ENTITY) @Optional override val entity: String? = null,
    @SerialName(DEFINITION_SOURCE) @Optional override val definitionSource: String? = null,
    @SerialName(HEADING) @Optional override val heading: String? = null,
    @SerialName(INFO_BOX) @Optional override val infoBox: String? = null,
    @SerialName(IMAGE) @Optional override val image: String? = null,
    @SerialName(ABSTRACT_URL) @Optional override val abstractUrl: String? = null,
    @SerialName(ANSWER_TYPE) @Optional override val answerType: String? = null,
    @SerialName(META) @Optional override val meta: Meta? = null,
    @SerialName(RELATED_TOPICS) @Optional override val relatedTopics: List<Result> = emptyList(),
    @SerialName(TYPE) @Optional override val type: String? = null,
    @SerialName(REDIRECT_URL) @Optional override val redirectUrl: String? = null,
    @SerialName(DEFINITION) @Optional override val definition: String? = null,
    @SerialName(IMAGE_WIDTH) @Optional override val imageWidth: Int? = null,
    @SerialName(IMAGE_HEIGHT) @Optional override val imageHeight: Int? = null,
    @SerialName(ANSWER) @Optional override val answer: String? = null,
    @SerialName(ABSTRACT_SOURCE) @Optional override val abstractSource: String? = null,
    @SerialName(ABSTRACT_IMAGE_URL) @Optional override val abstractImageUrl: String? = null,
    @SerialName(ABSTRACT_TOPIC) @Optional override val abstractTopic: String? = null
) : InstantAnswer