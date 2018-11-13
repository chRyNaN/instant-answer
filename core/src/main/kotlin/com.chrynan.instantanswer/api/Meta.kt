package com.chrynan.instantanswer.api

interface Meta {

    val blockGroup: String?
    val sourceId: Int?
    val status: String?
    val designer: String?
    val description: String?
    val liveDate: Long?
    val isStackExchange: Boolean?
    val sourceDomain: String?
    val tab: String?
    val sourceUrl: String?
    val unsafe: Int?
    val perlModule: String?
    val createdDate: Long?
    val productionState: String?
    val exampleQuery: String?
    val producer: String?
    val sourceName: String?
    val devDate: Long?
    val repo: String?
    val name: String?
    val jsCallbackName: String?
    val id: String?
    val attribution: String?
    val devMilestone: String?
    val signalFrom: String?
    val topics: List<String>
    val developers: List<Developer>
    val maintainer: Maintainer?
    val sourceOptions: SourceOptions?

    fun copyWith(
        blockGroup: String? = this.blockGroup,
        sourceId: Int? = this.sourceId,
        status: String? = this.status,
        designer: String? = this.designer,
        description: String? = this.description,
        liveDate: Long? = this.liveDate,
        isStackExchange: Boolean? = this.isStackExchange,
        sourceDomain: String? = this.sourceDomain,
        tab: String? = this.tab,
        sourceUrl: String? = this.sourceUrl,
        unsafe: Int? = this.unsafe,
        perlModule: String? = this.perlModule,
        createdDate: Long? = this.createdDate,
        productionState: String? = this.productionState,
        exampleQuery: String? = this.exampleQuery,
        producer: String? = this.producer,
        sourceName: String? = this.sourceName,
        devDate: Long? = this.devDate,
        repo: String? = this.repo,
        name: String? = this.name,
        jsCallbackName: String? = this.jsCallbackName,
        id: String? = this.id,
        attribution: String? = this.attribution,
        devMilestone: String? = this.devMilestone,
        signalFrom: String? = this.signalFrom,
        topics: List<String> = this.topics,
        developers: List<Developer> = this.developers,
        maintainer: Maintainer? = this.maintainer,
        sourceOptions: SourceOptions? = this.sourceOptions
    ): Meta
}