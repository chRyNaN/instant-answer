@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.InstantAnswerJson
import com.chrynan.instantanswer.MetaJson
import com.chrynan.instantanswer.ResultJson
import com.chrynan.instantanswer.WebIconJson
import com.chrynan.instantanswer.api.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class InstantAnswerJsonTypeAdapterFactory : JsonAdapter.Factory {

    private val typeAdapters: MutableMap<String, JsonAdapter<*>> = mutableMapOf()

    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        var adapter = typeAdapters[type.typeName]

        if (adapter == null && type is Class<*>) {
            val supportedType = type.getSupportedType()

            if (supportedType != null) {
                adapter = moshi.adapter(supportedType)

                typeAdapters[type.typeName] = adapter
            }
        }

        return adapter
    }

    private fun Class<*>.getSupportedType() = when {
        this == InstantAnswer::class.java -> InstantAnswerJson::class.java
        this == Result::class.java -> ResultJson::class.java
        this == Meta::class.java -> MetaJson::class.java
        this == SourceOptions::class.java -> MetaJson.SourceOptionsJson::class.java
        this == Developer::class.java -> MetaJson.DeveloperJson::class.java
        this == Maintainer::class.java -> MetaJson.MaintainerJson::class.java
        this == WebIcon::class.java -> WebIconJson::class.java
        else -> null
    }
}

fun Moshi.Builder.addInstantAnswerTypeFactory(): Moshi.Builder =
    add(StringAsIntOrNullTypeAdapter())
        .add(InstantAnswerJsonTypeAdapterFactory())