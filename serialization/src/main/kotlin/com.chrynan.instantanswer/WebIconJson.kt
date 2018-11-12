package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.WebIcon
import com.chrynan.instantanswer.fields.WebIconFields.HEIGHT
import com.chrynan.instantanswer.fields.WebIconFields.URL
import com.chrynan.instantanswer.fields.WebIconFields.WIDTH
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WebIconJson(
    @SerialName(URL) override val url: String? = null,
    @SerialName(HEIGHT) override val height: Int? = null,
    @SerialName(WIDTH) override val width: Int? = null
) : WebIcon