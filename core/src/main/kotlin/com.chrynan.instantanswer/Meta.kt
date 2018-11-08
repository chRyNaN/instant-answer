package com.chrynan.instantanswer

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
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName(BLOCK_GROUP) @Optional val blockGroup: String? = null,
    @SerialName(SOURCE_ID) @Optional val sourceId: Int? = null,
    @SerialName(STATUS) @Optional val status: String? = null,
    @SerialName(DESIGNER) @Optional val designer: String? = null,
    @SerialName(DESCRIPTION) @Optional val description: String? = null,
    @SerialName(LIVE_DATE) @Optional val liveDate: Long? = null,
    @SerialName(IS_STACK_EXCHANGE) @Optional val isStackExchange: Boolean? = null,
    @SerialName(SOURCE_DOMAIN) @Optional val sourceDomain: String? = null,
    @SerialName(TAB) @Optional val tab: String? = null,
    @SerialName(SOURCE_URL) @Optional val sourceUrl: String? = null,
    @SerialName(UNSAFE) @Optional val unsafe: Int? = null,
    @SerialName(PERL_MODULE) @Optional val perlModule: String? = null,
    @SerialName(CREATED_DATE) @Optional val createdDate: Long? = null,
    @SerialName(PRODUCTION_STATE) @Optional val productionState: String? = null,
    @SerialName(EXAMPLE_QUERY) @Optional val exampleQuery: String? = null,
    @SerialName(PRODUCER) @Optional val producer: String? = null,
    @SerialName(SOURCE_NAME) @Optional val sourceName: String? = null,
    @SerialName(DEV_DATE) @Optional val devDate: Long? = null,
    @SerialName(REPO) @Optional val repo: String? = null,
    @SerialName(MetaFields.NAME) @Optional val name: String? = null,
    @SerialName(JS_CALLBACK_NAME) @Optional val jsCallbackName: String? = null,
    @SerialName(ID) @Optional val id: String? = null,
    @SerialName(ATTRIBUTION) @Optional val attribution: String? = null,
    @SerialName(DEV_MILESTONE) @Optional val devMilestone: String? = null,
    @SerialName(SIGNAL_FROM) @Optional val signalFrom: String? = null,
    @SerialName(TOPICS) @Optional val topics: List<String> = emptyList(),
    @SerialName(DEVELOPERS) @Optional val developers: List<Developer> = emptyList(),
    @SerialName(MAINTAINER) @Optional val maintainer: Maintainer? = null,
    @SerialName(SOURCE_OPTIONS) @Optional val sourceOptions: SourceOptions? = null
) {

    @Serializable
    data class SourceOptions(
        @SerialName(IS_MEDIA_WIKI) @Optional val isMediaWiki: Boolean? = null,
        @SerialName(LANGUAGE) @Optional val language: String? = null,
        @SerialName(SKIP_ABSTRACT) @Optional val skipAbstract: Boolean? = null,
        @SerialName(IS_WIKIPEDIA) @Optional val isWikipedia: Boolean? = null,
        @SerialName(SOURCE_SKIP) @Optional val sourceSkip: String? = null,
        @SerialName(SOURCE_INFO) @Optional val sourceInfo: String? = null,
        @SerialName(DIRECTORY) @Optional val directory: String? = null,
        @SerialName(MIN_ABSTRACT_LENGTH) @Optional val minAbstractLength: String? = null,
        @SerialName(SKIP_QR) @Optional val skipQr: String? = null,
        @SerialName(IS_FANON) @Optional val isFanon: Boolean? = null,
        @SerialName(SKIP_ABSTRACT_PAREN) @Optional val skipAbstractParen: Boolean? = null,
        @SerialName(SKIP_END) @Optional val skipEnd: Boolean? = null,
        @SerialName(SKIP_ICON) @Optional val skipIcon: Boolean? = null,
        @SerialName(SKIP_IMAGE_NAME) @Optional val skipImageName: Boolean? = null
    )

    @Serializable
    data class Developer(
        @SerialName(URL) @Optional val url: String? = null,
        @SerialName(TYPE) @Optional val type: String? = null,
        @SerialName(DeveloperFields.NAME) @Optional val name: String? = null
    )

    @Serializable
    data class Maintainer(@SerialName(GITHUB) @Optional val github: String? = null)
}