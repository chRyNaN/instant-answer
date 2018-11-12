@file:Suppress("unused")

package com.chrynan.instantanswer

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class StringAsIntOrNullTypeAdapter {

    @ToJson
    fun toJson(value: Int?): String? = value?.toString()

    @FromJson
    fun fromJson(json: String?): Int? = json?.toIntOrNull()
}