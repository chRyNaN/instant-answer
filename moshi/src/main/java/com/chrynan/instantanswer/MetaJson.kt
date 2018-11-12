@file:Suppress("unused")

package com.chrynan.instantanswer

import com.chrynan.instantanswer.api.Developer
import com.chrynan.instantanswer.api.Maintainer
import com.chrynan.instantanswer.api.Meta
import com.chrynan.instantanswer.api.SourceOptions
import com.chrynan.instantanswer.fields.DeveloperFields
import com.chrynan.instantanswer.fields.DeveloperFields.TYPE
import com.chrynan.instantanswer.fields.DeveloperFields.URL
import com.chrynan.instantanswer.fields.MaintainerFields.GITHUB
import com.chrynan.instantanswer.fields.MetaFields
import com.chrynan.instantanswer.fields.MetaFields.ATTRIBUTION
import com.chrynan.instantanswer.fields.MetaFields.BLOCK_GROUP
import com.chrynan.instantanswer.fields.MetaFields.CREATED_DATE
import com.chrynan.instantanswer.fields.MetaFields.DESCRIPTION
import com.chrynan.instantanswer.fields.MetaFields.DESIGNER
import com.chrynan.instantanswer.fields.MetaFields.DEVELOPERS
import com.chrynan.instantanswer.fields.MetaFields.DEV_DATE
import com.chrynan.instantanswer.fields.MetaFields.DEV_MILESTONE
import com.chrynan.instantanswer.fields.MetaFields.EXAMPLE_QUERY
import com.chrynan.instantanswer.fields.MetaFields.ID
import com.chrynan.instantanswer.fields.MetaFields.IS_STACK_EXCHANGE
import com.chrynan.instantanswer.fields.MetaFields.JS_CALLBACK_NAME
import com.chrynan.instantanswer.fields.MetaFields.LIVE_DATE
import com.chrynan.instantanswer.fields.MetaFields.MAINTAINER
import com.chrynan.instantanswer.fields.MetaFields.PERL_MODULE
import com.chrynan.instantanswer.fields.MetaFields.PRODUCER
import com.chrynan.instantanswer.fields.MetaFields.PRODUCTION_STATE
import com.chrynan.instantanswer.fields.MetaFields.REPO
import com.chrynan.instantanswer.fields.MetaFields.SIGNAL_FROM
import com.chrynan.instantanswer.fields.MetaFields.SOURCE_DOMAIN
import com.chrynan.instantanswer.fields.MetaFields.SOURCE_ID
import com.chrynan.instantanswer.fields.MetaFields.SOURCE_NAME
import com.chrynan.instantanswer.fields.MetaFields.SOURCE_OPTIONS
import com.chrynan.instantanswer.fields.MetaFields.SOURCE_URL
import com.chrynan.instantanswer.fields.MetaFields.STATUS
import com.chrynan.instantanswer.fields.MetaFields.TAB
import com.chrynan.instantanswer.fields.MetaFields.TOPICS
import com.chrynan.instantanswer.fields.MetaFields.UNSAFE
import com.chrynan.instantanswer.fields.SourceOptionsFields.DIRECTORY
import com.chrynan.instantanswer.fields.SourceOptionsFields.IS_FANON
import com.chrynan.instantanswer.fields.SourceOptionsFields.IS_MEDIA_WIKI
import com.chrynan.instantanswer.fields.SourceOptionsFields.IS_WIKIPEDIA
import com.chrynan.instantanswer.fields.SourceOptionsFields.LANGUAGE
import com.chrynan.instantanswer.fields.SourceOptionsFields.MIN_ABSTRACT_LENGTH
import com.chrynan.instantanswer.fields.SourceOptionsFields.SKIP_ABSTRACT
import com.chrynan.instantanswer.fields.SourceOptionsFields.SKIP_ABSTRACT_PAREN
import com.chrynan.instantanswer.fields.SourceOptionsFields.SKIP_END
import com.chrynan.instantanswer.fields.SourceOptionsFields.SKIP_ICON
import com.chrynan.instantanswer.fields.SourceOptionsFields.SKIP_IMAGE_NAME
import com.chrynan.instantanswer.fields.SourceOptionsFields.SKIP_QR
import com.chrynan.instantanswer.fields.SourceOptionsFields.SOURCE_INFO
import com.chrynan.instantanswer.fields.SourceOptionsFields.SOURCE_SKIP
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaJson(
    @field:Json(name = BLOCK_GROUP) override val blockGroup: String? = null,
    @field:Json(name = SOURCE_ID) override val sourceId: Int? = null,
    @field:Json(name = STATUS) override val status: String? = null,
    @field:Json(name = DESIGNER) override val designer: String? = null,
    @field:Json(name = DESCRIPTION) override val description: String? = null,
    @field:Json(name = LIVE_DATE) override val liveDate: Long? = null,
    @field:Json(name = IS_STACK_EXCHANGE) override val isStackExchange: Boolean? = null,
    @field:Json(name = SOURCE_DOMAIN) override val sourceDomain: String? = null,
    @field:Json(name = TAB) override val tab: String? = null,
    @field:Json(name = SOURCE_URL) override val sourceUrl: String? = null,
    @field:Json(name = UNSAFE) override val unsafe: Int? = null,
    @field:Json(name = PERL_MODULE) override val perlModule: String? = null,
    @field:Json(name = CREATED_DATE) override val createdDate: Long? = null,
    @field:Json(name = PRODUCTION_STATE) override val productionState: String? = null,
    @field:Json(name = EXAMPLE_QUERY) override val exampleQuery: String? = null,
    @field:Json(name = PRODUCER) override val producer: String? = null,
    @field:Json(name = SOURCE_NAME) override val sourceName: String? = null,
    @field:Json(name = DEV_DATE) override val devDate: Long? = null,
    @field:Json(name = REPO) override val repo: String? = null,
    @field:Json(name = MetaFields.NAME) override val name: String? = null,
    @field:Json(name = JS_CALLBACK_NAME) override val jsCallbackName: String? = null,
    @field:Json(name = ID) override val id: String? = null,
    @field:Json(name = ATTRIBUTION) override val attribution: String? = null,
    @field:Json(name = DEV_MILESTONE) override val devMilestone: String? = null,
    @field:Json(name = SIGNAL_FROM) override val signalFrom: String? = null,
    @field:Json(name = TOPICS) override val topics: List<String> = emptyList(),
    @field:Json(name = DEVELOPERS) override val developers: List<Developer> = emptyList(),
    @field:Json(name = MAINTAINER) override val maintainer: Maintainer? = null,
    @field:Json(name = SOURCE_OPTIONS) override val sourceOptions: SourceOptions? = null
) : Meta {

    @JsonClass(generateAdapter = true)
    data class SourceOptionsJson(
        @field:Json(name = IS_MEDIA_WIKI) override val isMediaWiki: Boolean? = null,
        @field:Json(name = LANGUAGE) override val language: String? = null,
        @field:Json(name = SKIP_ABSTRACT) override val skipAbstract: Boolean? = null,
        @field:Json(name = IS_WIKIPEDIA) override val isWikipedia: Boolean? = null,
        @field:Json(name = SOURCE_SKIP) override val sourceSkip: String? = null,
        @field:Json(name = SOURCE_INFO) override val sourceInfo: String? = null,
        @field:Json(name = DIRECTORY) override val directory: String? = null,
        @field:Json(name = MIN_ABSTRACT_LENGTH) override val minAbstractLength: String? = null,
        @field:Json(name = SKIP_QR) override val skipQr: String? = null,
        @field:Json(name = IS_FANON) override val isFanon: Boolean? = null,
        @field:Json(name = SKIP_ABSTRACT_PAREN) override val skipAbstractParen: Boolean? = null,
        @field:Json(name = SKIP_END) override val skipEnd: Boolean? = null,
        @field:Json(name = SKIP_ICON) override val skipIcon: Boolean? = null,
        @field:Json(name = SKIP_IMAGE_NAME) override val skipImageName: Boolean? = null
    ) : SourceOptions

    @JsonClass(generateAdapter = true)
    data class DeveloperJson(
        @field:Json(name = URL) override val url: String? = null,
        @field:Json(name = TYPE) override val type: String? = null,
        @field:Json(name = DeveloperFields.NAME) override val name: String? = null
    ) : Developer

    @JsonClass(generateAdapter = true)
    data class MaintainerJson(@field:Json(name = GITHUB) override val github: String? = null) : Maintainer
}