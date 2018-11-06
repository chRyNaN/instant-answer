@file:Suppress("unused")

package com.chrynan.instantanswer

const val DUCK_DUCK_GO_INSTANT_ANSWER_BASE_API_ENDPOINT = "api.duckduckgo.com"

fun getDuckDuckGoInstantAnswerEndpoint(
    secure: Boolean = true,
    noRedirect: Boolean = true,
    query: String,
    description: String
) =
    (if (secure) "https" else "http") +
            "$DUCK_DUCK_GO_INSTANT_ANSWER_BASE_API_ENDPOINT/" +
            "?format=json" +
            "&no_redirect=${if (noRedirect) "1" else "0"}" +
            "&q=$query&" +
            "&t=$description"