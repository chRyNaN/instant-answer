@file:Suppress("unused")

package com.chrynan.instantanswer

val Result.containsValidFields: Boolean
    get() = (this is Result.TopicResult && !url.isNullOrBlank() && !text.isNullOrBlank()) || (this is Result.NestedResult && !name.isNullOrBlank() && topics.isNotEmpty())