package com.chrynan.instantanswer.api

interface Developer {

    val url: String?
    val type: String?
    val name: String?

    fun copyWith(url: String? = this.url, type: String? = this.type, name: String? = this.name): Developer
}