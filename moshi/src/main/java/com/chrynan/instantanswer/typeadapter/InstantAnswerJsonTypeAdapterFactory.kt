@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.InstantAnswerJson
import com.chrynan.instantanswer.MetaJson
import com.chrynan.instantanswer.WebIconJson
import com.chrynan.instantanswer.api.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class InstantAnswerJsonTypeAdapterFactory : JsonAdapter.Factory {

    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? =
        when (type) {
            is InstantAnswer -> moshi.adapter(InstantAnswerJson::class.java)
            is Result -> ResultTypeAdapter(moshi)
            is Meta -> moshi.adapter(MetaJson::class.java)
            is SourceOptions -> moshi.adapter(MetaJson.SourceOptionsJson::class.java)
            is Developer -> moshi.adapter(MetaJson.DeveloperJson::class.java)
            is Maintainer -> moshi.adapter(MetaJson.MaintainerJson::class.java)
            is WebIcon -> moshi.adapter(WebIconJson::class.java)
            else -> null
        }
}

fun Moshi.Builder.addInstantAnswerTypeFactory(): Moshi.Builder = add(InstantAnswerJsonTypeAdapterFactory())