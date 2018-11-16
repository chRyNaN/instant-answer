@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.StringAsIntOrNull
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class StringAsIntOrNullTypeAdapter {

    @ToJson
    fun toJson(@StringAsIntOrNull value: Int?) = value?.toString()

    @FromJson
    fun fromJson(json: String?) = json?.toIntOrNull()
}