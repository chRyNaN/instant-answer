@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.NestedResult
import com.chrynan.instantanswer.api.Result
import com.chrynan.instantanswer.api.TopicResult

val Result.containsValidFields: Boolean
    get() = (this is TopicResult && !url.isNullOrBlank() && !text.isNullOrBlank()) || (this is NestedResult && !name.isNullOrBlank() && topics.isNotEmpty())