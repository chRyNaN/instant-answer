@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.api.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class InstantAnswerJsonTypeAdapterFactory : JsonAdapter.Factory {

    private val typeAdapters: MutableMap<String, JsonAdapter<*>> = mutableMapOf()

    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        var adapter = typeAdapters[type.typeName]

        if (adapter == null && type is Class<*> && type.isSupportedType()) {
            adapter = moshi.adapter(type)

            typeAdapters[type.typeName] = adapter
        }

        return adapter
    }

    private fun Class<*>.isSupportedType() =
        (this == InstantAnswer::class.java) ||
                (this == Result::class.java) ||
                (this == Meta::class.java) ||
                (this == SourceOptions::class.java) ||
                (this == Developer::class.java) ||
                (this == Maintainer::class.java) ||
                (this == WebIcon::class.java)
}

fun Moshi.Builder.addInstantAnswerTypeFactory(): Moshi.Builder = add(InstantAnswerJsonTypeAdapterFactory())