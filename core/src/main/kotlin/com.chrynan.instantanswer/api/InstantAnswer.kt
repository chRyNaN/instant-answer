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
}