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
}