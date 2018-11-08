@file:Suppress("unused")

package com.chrynan.instantanswer

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
data class InstantAnswer(
    @SerialName(RESULTS) @Optional val results: List<Result> = emptyList(),
    @SerialName(ABSTRACT) @Optional val abstract: String? = null,
    @SerialName(ABSTRACT_TEXT) @Optional val abstractText: String? = null,
    @SerialName(DEFINITION_URL) @Optional val definitionUrl: String? = null,
    @SerialName(IMAGE_IS_LOGO) @Optional val imageIsLogo: Boolean? = null,
    @SerialName(ENTITY) @Optional val entity: String? = null,
    @SerialName(DEFINITION_SOURCE) @Optional val definitionSource: String? = null,
    @SerialName(HEADING) @Optional val heading: String? = null,
    @SerialName(INFO_BOX) @Optional val infoBox: String? = null,
    @SerialName(IMAGE) @Optional val image: String? = null,
    @SerialName(ABSTRACT_URL) @Optional val abstractUrl: String? = null,
    @SerialName(ANSWER_TYPE) @Optional val answerType: String? = null,
    @SerialName(META) @Optional val meta: Meta? = null,
    @SerialName(RELATED_TOPICS) @Optional val relatedTopics: List<Result> = emptyList(),
    @SerialName(TYPE) @Optional val type: String? = null,
    @SerialName(REDIRECT_URL) @Optional val redirectUrl: String? = null,
    @SerialName(DEFINITION) @Optional val definition: String? = null,
    @SerialName(IMAGE_WIDTH) @Optional val imageWidth: Int? = null,
    @SerialName(IMAGE_HEIGHT) @Optional val imageHeight: Int? = null,
    @SerialName(ANSWER) @Optional val answer: String? = null,
    @SerialName(ABSTRACT_SOURCE) @Optional val abstractSource: String? = null,
    @SerialName(ABSTRACT_IMAGE_URL) @Optional val abstractImageUrl: String? = null,
    @SerialName(ABSTRACT_TOPIC) @Optional val abstractTopic: String? = null
)