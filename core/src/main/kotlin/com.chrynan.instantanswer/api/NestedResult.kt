package com.chrynan.instantanswer.api

interface NestedResult : Result {

    val name: String?
    val topics: List<TopicResult>

    fun copyWith(name: String? = this.name, topics: List<TopicResult> = this.topics): NestedResult
}