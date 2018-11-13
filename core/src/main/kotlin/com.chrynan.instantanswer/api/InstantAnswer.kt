package com.chrynan.instantanswer.api

interface InstantAnswer {

    val results: List<Result>
    val abstract: String?
    val abstractText: String?
    val definitionUrl: String?
    val imageIsLogo: Boolean?
    val entity: String?
    val definitionSource: String?
    val heading: String?
    val infoBox: String?
    val image: String?
    val abstractUrl: String?
    val answerType: String?
    val meta: Meta?
    val relatedTopics: List<Result>
    val type: String?
    val redirectUrl: String?
    val definition: String?
    val imageWidth: Int?
    val imageHeight: Int?
    val answer: String?
    val abstractSource: String?
    val abstractImageUrl: String?
    val abstractTopic: String?

    fun copyWith(
        results: List<Result> = this.results,
        abstract: String? = this.abstract,
        abstractText: String? = this.abstractText,
        definitionUrl: String? = this.definitionUrl,
        imageIsLogo: Boolean? = this.imageIsLogo,
        entity: String? = this.entity,
        definitionSource: String? = this.definitionSource,
        heading: String? = this.heading,
        infoBox: String? = this.infoBox,
        image: String? = this.image,
        abstractUrl: String? = this.abstractUrl,
        answerType: String? = this.answerType,
        meta: Meta? = this.meta,
        relatedTopics: List<Result> = this.relatedTopics,
        type: String? = this.type,
        redirectUrl: String? = this.redirectUrl,
        definition: String? = this.definition,
        imageWidth: Int? = this.imageWidth,
        imageHeight: Int? = this.imageHeight,
        answer: String? = this.answer,
        abstractSource: String? = this.abstractSource,
        abstractImageUrl: String? = this.abstractImageUrl,
        abstractTopic: String? = this.abstractTopic
    ): InstantAnswer
}