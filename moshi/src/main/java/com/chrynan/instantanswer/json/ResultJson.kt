@file:Suppress("unused")

package com.chrynan.instantanswer.json

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
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

sealed class ResultJson : Result {

    @JsonClass(generateAdapter = true)
    data class TopicResultJson(
        @field:Json(name = WEB_ICON) override val webIcon: WebIcon? = null,
        @field:Json(name = URL) override val url: String? = null,
        @field:Json(name = TEXT) override val text: String? = null,
        @field:Json(name = HTML_FORMATTED_TEXT) override val htmlFormattedText: String? = null
    ) : ResultJson(),
        TopicResult {

        override fun copyWith(webIcon: WebIcon?, url: String?, text: String?, htmlFormattedText: String?) =
            copy(webIcon = webIcon, url = url, text = text, htmlFormattedText = htmlFormattedText)
    }

    @JsonClass(generateAdapter = true)
    data class NestedResultJson(
        @field:Json(name = NAME) override val name: String? = null,
        @field:Json(name = TOPICS) override val topics: List<TopicResult> = emptyList()
    ) : ResultJson(),
        NestedResult {

        override fun copyWith(name: String?, topics: List<TopicResult>) = copy(name = name, topics = topics)
    }
}