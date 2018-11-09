@file:Suppress("unused")

package com.chrynan.instantanswer

val InstantAnswerJson.containsValidAnswer: Boolean
    get() = !answer.isNullOrBlank()

val InstantAnswerJson.containsValidAnswerType: Boolean
    get() = !answerType.isNullOrBlank()

val InstantAnswerJson.containsValidDefinition: Boolean
    get() = !definition.isNullOrBlank()

val InstantAnswerJson.containsValidDefinitionSource: Boolean
    get() = !definitionSource.isNullOrBlank()

val InstantAnswerJson.containsValidDefinitionUrl: Boolean
    get() = !definitionUrl.isNullOrBlank()

val InstantAnswerJson.containsRelatedTopics: Boolean
    get() = relatedTopics.isNotEmpty()

val InstantAnswerJson.containsResults: Boolean
    get() = results.isNotEmpty()