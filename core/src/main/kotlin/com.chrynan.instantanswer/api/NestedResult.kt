package com.chrynan.instantanswer.api

interface NestedResult : Result {

    val name: String?
    val topics: List<Result>

    fun copyWith(name: String? = this.name, topics: List<Result> = this.topics): NestedResult
}