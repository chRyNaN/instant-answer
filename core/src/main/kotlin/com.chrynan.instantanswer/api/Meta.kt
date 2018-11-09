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
}