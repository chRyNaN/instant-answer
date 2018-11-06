package com.chrynan.instantanswer

data class Meta(
    val blockGroup: String? = null,
    val sourceId: Int? = null,
    val status: String? = null,
    val designer: String? = null,
    val description: String? = null,
    val liveDate: Long? = null,
    val isStackExchange: Boolean? = null,
    val sourceDomain: String? = null,
    val tab: String? = null,
    val sourceUrl: String? = null,
    val unsafe: Int? = null,
    val perlModule: String? = null,
    val createdDate: Long? = null,
    val productionState: String? = null,
    val exampleQuery: String? = null,
    val producer: String? = null,
    val sourceName: String? = null,
    val devDate: Long? = null,
    val repo: String? = null,
    val name: String? = null,
    val jsCallbackName: String? = null,
    val id: String? = null,
    val attribution: String? = null,
    val devMilestone: String? = null,
    val signalFrom: String? = null,
    val topics: List<String> = emptyList(),
    val developers: List<Developer> = emptyList(),
    val maintainer: Maintainer? = null,
    val sourceOptions: SourceOptions? = null
) {

    data class SourceOptions(
        val isMediaWiki: Boolean? = null,
        val language: String? = null,
        val skipAbstract: Boolean? = null,
        val isWikipedia: Boolean? = null,
        val sourceSkip: String? = null,
        val sourceInfo: String? = null,
        val directory: String? = null,
        val minAbstractLength: String? = null,
        val skipQr: String? = null,
        val isFanon: Boolean? = null,
        val skipAbstractParen: Boolean? = null,
        val skipEnd: Boolean? = null,
        val skipIcon: Boolean? = null,
        val skipImageName: Boolean? = null
    )

    data class Developer(
        val url: String? = null,
        val type: String? = null,
        val name: String? = null
    )

    data class Maintainer(val github: String? = null)
}