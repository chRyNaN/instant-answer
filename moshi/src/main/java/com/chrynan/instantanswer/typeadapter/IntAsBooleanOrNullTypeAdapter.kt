@file:Suppress("unused")

package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.IntAsBooleanOrNull
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class IntAsBooleanOrNullTypeAdapter {

    @ToJson
    fun toJson(@IntAsBooleanOrNull value: Boolean?) = value?.let { if (it) 1 else 0 }

    @FromJson
    fun fromJson(json: Int?) = json?.let { it == 1 }
}