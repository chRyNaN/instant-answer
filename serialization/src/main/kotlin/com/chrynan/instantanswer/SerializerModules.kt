@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.serializer.*
import kotlinx.serialization.context.CompositeModule
import kotlinx.serialization.context.SimpleModule
import kotlinx.serialization.json.JSON

val instantAnswerModule by lazy { SimpleModule(InstantAnswer::class, InstantAnswerJsonSerializer) }
val developerModule by lazy { SimpleModule(Meta.Developer::class, DeveloperJsonSerializer) }
val maintainerModule by lazy { SimpleModule(Meta.Maintainer::class, MaintainerJsonSerializer) }
val metaModule by lazy { SimpleModule(Meta::class, MetaJsonSerializer) }
val resultModule by lazy { SimpleModule(Result::class, ResultJsonSerializer) }
val sourceOptionsModule by lazy { SimpleModule(Meta.SourceOptions::class, SourceOptionsJsonSerializer) }
val webIconModule by lazy { SimpleModule(WebIcon::class, WebIconJsonSerializer) }
val instantAnswerModules by lazy {
    CompositeModule(
        listOf(
            instantAnswerModule,
            developerModule,
            maintainerModule,
            metaModule,
            resultModule,
            sourceOptionsModule,
            webIconModule
        )
    )
}
val justInstantAnswerJSON = JSON().apply { install(instantAnswerModules) }
val instantAnswerJSON = JSON.apply { install(instantAnswerModules) }