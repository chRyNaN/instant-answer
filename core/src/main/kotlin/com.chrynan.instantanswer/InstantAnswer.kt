@file:Suppress("unused")

package com.chrynan.instantanswer

data class InstantAnswer(
    val results: List<Result> = emptyList(),
    val abstract: String? = null,
    val abstractText: String? = null,
    val definitionUrl: String? = null,
    val imageIsLogo: Boolean? = null,
    val entity: String? = null,
    val definitionSource: String? = null,
    val heading: String? = null,
    val infoBox: String? = null,
    val image: String? = null,
    val abstractUrl: String? = null,
    val answerType: String? = null,
    val meta: Meta? = null,
    val relatedTopics: List<Result> = emptyList(),
    val type: String? = null,
    val redirectUrl: String? = null,
    val definition: String? = null,
    val imageWidth: Int? = null,
    val imageHeight: Int? = null,
    val answer: String? = null,
    val abstractSource: String? = null,
    val abstractImageUrl: String? = null,
    val abstractTopic: String? = null
)