@file:Suppress("unused")

package com.chrynan.instantanswer

sealed class Result {

    data class TopicResult(
        val webIcon: WebIcon? = null,
        val url: String? = null,
        val text: String? = null,
        val htmlFormattedText: String? = null
    ) : Result()

    data class NestedResult(
        val name: String? = null,
        val topics: List<Result> = emptyList()
    ) : Result()
}