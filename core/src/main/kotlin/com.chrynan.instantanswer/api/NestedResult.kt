package com.chrynan.instantanswer.api

interface NestedResult : Result {

    val name: String?
    val topics: List<Result>
}