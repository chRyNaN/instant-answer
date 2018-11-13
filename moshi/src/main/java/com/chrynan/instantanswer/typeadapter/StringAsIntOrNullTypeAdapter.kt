@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class StringAsIntOrNullTypeAdapter {

    @ToJson
    fun toJson(value: Int?) = value?.toString()

    @FromJson
    fun fromJson(json: String?) = json?.toIntOrNull()
}