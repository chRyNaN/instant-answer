@file:Suppress("unused")

package com.chrynan.instantanswer

val ResultJson.containsValidFields: Boolean
    get() = (this is ResultJson.TopicResultJson && !url.isNullOrBlank() && !text.isNullOrBlank()) || (this is ResultJson.NestedResultJson && !name.isNullOrBlank() && topics.isNotEmpty())