package com.chrynan.instantanswer.api

interface TopicResult : Result {

    val webIcon: WebIcon?
    val url: String?
    val text: String?
    val htmlFormattedText: String?
}