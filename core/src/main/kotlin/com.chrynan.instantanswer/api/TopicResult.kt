package com.chrynan.instantanswer.api

interface TopicResult : Result {

    val webIcon: WebIcon?
    val url: String?
    val text: String?
    val htmlFormattedText: String?

    fun copyWith(
        webIcon: WebIcon? = this.webIcon,
        url: String? = this.url,
        text: String? = this.text,
        htmlFormattedText: String? = this.htmlFormattedText
    ): TopicResult
}