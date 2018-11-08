package com.chrynan.instantanswer

import com.chrynan.instantanswer.fields.WebIconFields.HEIGHT
import com.chrynan.instantanswer.fields.WebIconFields.URL
import com.chrynan.instantanswer.fields.WebIconFields.WIDTH
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WebIcon(
    @SerialName(URL) val url: String? = null,
    @SerialName(HEIGHT) val height: Int? = null,
    @SerialName(WIDTH) val width: Int? = null
)