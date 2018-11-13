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
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaJson(
    @SerialName(BLOCK_GROUP) @Optional override val blockGroup: String? = null,
    @SerialName(SOURCE_ID) @Optional override val sourceId: Int? = null,
    @SerialName(STATUS) @Optional override val status: String? = null,
    @SerialName(DESIGNER) @Optional override val designer: String? = null,
    @SerialName(DESCRIPTION) @Optional override val description: String? = null,
    @SerialName(LIVE_DATE) @Optional override val liveDate: Long? = null,
    @SerialName(IS_STACK_EXCHANGE) @Optional override val isStackExchange: Boolean? = null,
    @SerialName(SOURCE_DOMAIN) @Optional override val sourceDomain: String? = null,
    @SerialName(TAB) @Optional override val tab: String? = null,
    @SerialName(SOURCE_URL) @Optional override val sourceUrl: String? = null,
    @SerialName(UNSAFE) @Optional override val unsafe: Int? = null,
    @SerialName(PERL_MODULE) @Optional override val perlModule: String? = null,
    @SerialName(CREATED_DATE) @Optional override val createdDate: Long? = null,
    @SerialName(PRODUCTION_STATE) @Optional override val productionState: String? = null,
    @SerialName(EXAMPLE_QUERY) @Optional override val exampleQuery: String? = null,
    @SerialName(PRODUCER) @Optional override val producer: String? = null,
    @SerialName(SOURCE_NAME) @Optional override val sourceName: String? = null,
    @SerialName(DEV_DATE) @Optional override val devDate: Long? = null,
    @SerialName(REPO) @Optional override val repo: String? = null,
    @SerialName(MetaFields.NAME) @Optional override val name: String? = null,
    @SerialName(JS_CALLBACK_NAME) @Optional override val jsCallbackName: String? = null,
    @SerialName(ID) @Optional override val id: String? = null,
    @SerialName(ATTRIBUTION) @Optional override val attribution: String? = null,
    @SerialName(DEV_MILESTONE) @Optional override val devMilestone: String? = null,
    @SerialName(SIGNAL_FROM) @Optional override val signalFrom: String? = null,
    @SerialName(TOPICS) @Optional override val topics: List<String> = emptyList(),
    @SerialName(DEVELOPERS) @Optional override val developers: List<Developer> = emptyList(),
    @SerialName(MAINTAINER) @Optional override val maintainer: Maintainer? = null,
    @SerialName(SOURCE_OPTIONS) @Optional override val sourceOptions: SourceOptions? = null
) : Meta {

    override fun copyWith(
        blockGroup: String?,
        sourceId: Int?,
        status: String?,
        designer: String?,
        description: String?,
        liveDate: Long?,
        isStackExchange: Boolean?,
        sourceDomain: String?,
        tab: String?,
        sourceUrl: String?,
        unsafe: Int?,
        perlModule: String?,
        createdDate: Long?,
        productionState: String?,
        exampleQuery: String?,
        producer: String?,
        sourceName: String?,
        devDate: Long?,
        repo: String?,
        name: String?,
        jsCallbackName: String?,
        id: String?,
        attribution: String?,
        devMilestone: String?,
        signalFrom: String?,
        topics: List<String>,
        developers: List<Developer>,
        maintainer: Maintainer?,
        sourceOptions: SourceOptions?
    ): Meta = copy(
        blockGroup = blockGroup,
        sourceId = sourceId,
        status = status,
        designer = designer,
        description = description,
        liveDate = liveDate,
        isStackExchange = isStackExchange,
        sourceDomain = sourceDomain,
        tab = tab,
        sourceUrl = sourceUrl,
        unsafe = unsafe,
        perlModule = perlModule,
        createdDate = createdDate,
        productionState = productionState,
        exampleQuery = exampleQuery,
        producer = producer,
        sourceName = sourceName,
        devDate = devDate,
        repo = repo,
        name = name,
        jsCallbackName = jsCallbackName,
        id = id,
        attribution = attribution,
        devMilestone = devMilestone,
        signalFrom = signalFrom,
        topics = topics,
        developers = developers,
        maintainer = maintainer,
        sourceOptions = sourceOptions
    )

    @Serializable
    data class SourceOptionsJson(
        @SerialName(IS_MEDIA_WIKI) @Optional override val isMediaWiki: Boolean? = null,
        @SerialName(LANGUAGE) @Optional override val language: String? = null,
        @SerialName(SKIP_ABSTRACT) @Optional override val skipAbstract: Boolean? = null,
        @SerialName(IS_WIKIPEDIA) @Optional override val isWikipedia: Boolean? = null,
        @SerialName(SOURCE_SKIP) @Optional override val sourceSkip: String? = null,
        @SerialName(SOURCE_INFO) @Optional override val sourceInfo: String? = null,
        @SerialName(DIRECTORY) @Optional override val directory: String? = null,
        @SerialName(MIN_ABSTRACT_LENGTH) @Optional override val minAbstractLength: String? = null,
        @SerialName(SKIP_QR) @Optional override val skipQr: String? = null,
        @SerialName(IS_FANON) @Optional override val isFanon: Boolean? = null,
        @SerialName(SKIP_ABSTRACT_PAREN) @Optional override val skipAbstractParen: Boolean? = null,
        @SerialName(SKIP_END) @Optional override val skipEnd: Boolean? = null,
        @SerialName(SKIP_ICON) @Optional override val skipIcon: Boolean? = null,
        @SerialName(SKIP_IMAGE_NAME) @Optional override val skipImageName: Boolean? = null
    ) : SourceOptions {

        override fun copyWith(
            isMediaWiki: Boolean?,
            language: String?,
            skipAbstract: Boolean?,
            isWikipedia: Boolean?,
            sourceSkip: String?,
            sourceInfo: String?,
            directory: String?,
            minAbstractLength: String?,
            skipQr: String?,
            isFanon: Boolean?,
            skipAbstractParen: Boolean?,
            skipEnd: Boolean?,
            skipIcon: Boolean?,
            skipImageName: Boolean?
        ) = copy(
            isMediaWiki = isMediaWiki,
            language = language,
            skipAbstract = skipAbstract,
            isWikipedia = isWikipedia,
            sourceSkip = sourceSkip,
            sourceInfo = sourceInfo,
            directory = directory,
            minAbstractLength = minAbstractLength,
            skipQr = skipQr,
            isFanon = isFanon,
            skipAbstractParen = skipAbstractParen,
            skipEnd = skipEnd,
            skipIcon = skipIcon,
            skipImageName = skipImageName
        )
    }

    @Serializable
    data class DeveloperJson(
        @SerialName(URL) @Optional override val url: String? = null,
        @SerialName(TYPE) @Optional override val type: String? = null,
        @SerialName(DeveloperFields.NAME) @Optional override val name: String? = null
    ) : Developer {

        override fun copyWith(url: String?, type: String?, name: String?) = copy(url = url, type = type, name = name)
    }

    @Serializable
    data class MaintainerJson(@SerialName(GITHUB) @Optional override val github: String? = null) : Maintainer {

        override fun copyWith(github: String?) = copy(github = github)
    }
}