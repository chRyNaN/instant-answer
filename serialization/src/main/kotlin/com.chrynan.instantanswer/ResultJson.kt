@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.NestedResult
import com.chrynan.instantanswer.api.Result
import com.chrynan.instantanswer.api.TopicResult
import com.chrynan.instantanswer.api.WebIcon
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
sealed class ResultJson : Result {

    @Serializable
    data class TopicResultJson(
        @SerialName(WEB_ICON) @Optional override val webIcon: WebIcon? = null,
        @SerialName(URL) @Optional override val url: String? = null,
        @SerialName(TEXT) @Optional override val text: String? = null,
        @SerialName(HTML_FORMATTED_TEXT) @Optional override val htmlFormattedText: String? = null
    ) : ResultJson(),
        TopicResult {

        override fun copyWith(webIcon: WebIcon?, url: String?, text: String?, htmlFormattedText: String?) =
            copy(webIcon = webIcon, url = url, text = text, htmlFormattedText = htmlFormattedText)
    }

    @Serializable
    data class NestedResultJson(
        @SerialName(NAME) @Optional override val name: String? = null,
        @SerialName(TOPICS) @Optional override val topics: List<Result> = emptyList()
    ) : ResultJson(),
        NestedResult {

        override fun copyWith(name: String?, topics: List<Result>) = copy(name = name, topics = topics)
    }
}