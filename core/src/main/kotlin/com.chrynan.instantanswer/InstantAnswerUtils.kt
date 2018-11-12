@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.InstantAnswer

val InstantAnswer.containsValidAnswer: Boolean
    get() = !answer.isNullOrBlank()

val InstantAnswer.containsValidAnswerType: Boolean
    get() = !answerType.isNullOrBlank()

val InstantAnswer.containsValidDefinition: Boolean
    get() = !definition.isNullOrBlank()

val InstantAnswer.containsValidDefinitionSource: Boolean
    get() = !definitionSource.isNullOrBlank()

val InstantAnswer.containsValidDefinitionUrl: Boolean
    get() = !definitionUrl.isNullOrBlank()

val InstantAnswer.containsRelatedTopics: Boolean
    get() = relatedTopics.isNotEmpty()

val InstantAnswer.containsResults: Boolean
    get() = results.isNotEmpty()