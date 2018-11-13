package com.chrynan.instantanswer.api

interface WebIcon {

    val url: String?
    val height: Int?
    val width: Int?

    fun copyWith(url: String? = this.url, height: Int? = this.height, width: Int? = this.width): WebIcon
}