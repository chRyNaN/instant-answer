@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.WebIcon
import com.chrynan.instantanswer.fields.WebIconFields.HEIGHT
import com.chrynan.instantanswer.fields.WebIconFields.URL
import com.chrynan.instantanswer.fields.WebIconFields.WIDTH
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WebIconJson(
    @field:Json(name = URL) override val url: String? = null,
    @field:Json(name = HEIGHT) override val height: Int? = null,
    @field:Json(name = WIDTH) override val width: Int? = null
) : WebIcon