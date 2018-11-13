package com.chrynan.instantanswer.api

interface SourceOptions {

    val isMediaWiki: Boolean?
    val language: String?
    val skipAbstract: Boolean?
    val isWikipedia: Boolean?
    val sourceSkip: String?
    val sourceInfo: String?
    val directory: String?
    val minAbstractLength: String?
    val skipQr: String?
    val isFanon: Boolean?
    val skipAbstractParen: Boolean?
    val skipEnd: Boolean?
    val skipIcon: Boolean?
    val skipImageName: Boolean?

    fun copyWith(
        isMediaWiki: Boolean? = this.isMediaWiki,
        language: String? = this.language,
        skipAbstract: Boolean? = this.skipAbstract,
        isWikipedia: Boolean? = this.isWikipedia,
        sourceSkip: String? = this.sourceSkip,
        sourceInfo: String? = this.sourceInfo,
        directory: String? = this.directory,
        minAbstractLength: String? = this.minAbstractLength,
        skipQr: String? = this.skipQr,
        isFanon: Boolean? = this.isFanon,
        skipAbstractParen: Boolean? = this.skipAbstractParen,
        skipEnd: Boolean? = this.skipEnd,
        skipIcon: Boolean? = this.skipIcon,
        skipImageName: Boolean? = this.skipImageName
    ): SourceOptions
}