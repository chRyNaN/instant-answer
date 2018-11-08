@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.fields.ResultFields.HTML_FORMATTED_TEXT
import com.chrynan.instantanswer.fields.ResultFields.NAME
import com.chrynan.instantanswer.fields.ResultFields.TEXT
import com.chrynan.instantanswer.fields.ResultFields.TOPICS
import com.chrynan.instantanswer.fields.ResultFields.URL
import com.chrynan.instantanswer.fields.ResultFields.WEB_ICON
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable(with = ResultSerializer::class)
sealed class Result {

    @Serializable
    data class TopicResult(
        @SerialName(WEB_ICON) @Optional val webIcon: WebIcon? = null,
        @SerialName(URL) @Optional val url: String? = null,
        @SerialName(TEXT) @Optional val text: String? = null,
        @SerialName(HTML_FORMATTED_TEXT) @Optional val htmlFormattedText: String? = null
    ) : Result()

    @Serializable
    data class NestedResult(
        @SerialName(NAME) @Optional val name: String? = null,
        @SerialName(TOPICS) @Optional val topics: List<Result> = emptyList()
    ) : Result()
}