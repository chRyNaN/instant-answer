@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.ResultJson
import com.chrynan.instantanswer.api.NestedResult
import com.chrynan.instantanswer.api.Result
import com.chrynan.instantanswer.api.TopicResult
import com.chrynan.instantanswer.api.WebIcon
import com.squareup.moshi.*

class ResultTypeAdapter(private val moshi: Moshi) : JsonAdapter<Result>() {

    private val options: JsonReader.Options =
        JsonReader.Options.of("Name", "Topics", "Icon", "FirstURL", "Text", "ResultJson")

    private val nullableStringAdapter by lazy {
        moshi.adapter<String?>(String::class.java, emptySet())
    }
    private val nullableWebIconAdapter by lazy {
        moshi.adapter<WebIcon?>(WebIcon::class.java, emptySet(), "webIcon")
    }
    private val listOfResultAdapter by lazy {
        moshi.adapter<List<TopicResult>>(
            Types.newParameterizedType(List::class.java, ResultJson.TopicResultJson::class.java),
            emptySet(),
            "topics"
        )
    }

    private val topicResultAdapter: JsonAdapter<ResultJson.TopicResultJson> by lazy { moshi.adapter(ResultJson.TopicResultJson::class.java) }
    private val nestedResultAdapter: JsonAdapter<ResultJson.NestedResultJson> by lazy { moshi.adapter(ResultJson.NestedResultJson::class.java) }

    override fun fromJson(reader: JsonReader): Result? {
        // Unfortunately, it looks like we have to manually parse the JSON since this is a Kotlin sealed class

        // Nested Result Fields
        var name: String? = null
        var topicsString: String? = null

        // Topic Result Fields
        var webIcon: WebIcon? = null
        var url: String? = null
        var text: String? = null
        var htmlFormattedText: String? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(options)) {
                0 -> name = nullableStringAdapter.fromJson(reader)
                1 -> topicsString = nullableStringAdapter.fromJson(reader)
                2 -> webIcon = nullableWebIconAdapter.fromJson(reader)
                3 -> url = nullableStringAdapter.fromJson(reader)
                4 -> text = nullableStringAdapter.fromJson(reader)
                5 -> htmlFormattedText = nullableStringAdapter.fromJson(reader)
                -1 -> {
                    // Unknown name, skip it.
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()

        if (name != null && !topicsString.isNullOrBlank()) {
            val topics: List<TopicResult> = listOfResultAdapter.fromJson(topicsString) ?: emptyList()

            if (topics.isNotEmpty()) {
                return ResultJson.NestedResultJson(
                    name = name,
                    topics = topics
                )
            }
        }

        return ResultJson.TopicResultJson(
            webIcon = webIcon,
            url = url,
            text = text,
            htmlFormattedText = htmlFormattedText
        )
    }

    override fun toJson(writer: JsonWriter, value: Result?) {
        val nestedResult = value?.asNestedResultOrNull()
        val topicResult = value?.asTopicResultOrNull()

        if (nestedResult != null) {
            nestedResultAdapter.toJson(writer, nestedResult)
        } else if (topicResult != null) {
            topicResultAdapter.toJson(writer, topicResult)
        }
    }

    private fun Result.asTopicResultOrNull(): ResultJson.TopicResultJson? {
        if (this is ResultJson.TopicResultJson) return this

        if (this is TopicResult) {
            return ResultJson.TopicResultJson(
                webIcon = webIcon,
                url = url,
                htmlFormattedText = htmlFormattedText,
                text = text
            )
        }

        return null
    }

    private fun Result.asNestedResultOrNull(): ResultJson.NestedResultJson? {
        if (this is ResultJson.NestedResultJson) return this

        if (this is NestedResult) {
            return ResultJson.NestedResultJson(
                name = name,
                topics = topics
            )
        }

        return null
    }
}