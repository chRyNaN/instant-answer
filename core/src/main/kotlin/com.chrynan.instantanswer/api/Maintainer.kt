package com.chrynan.instantanswer.api

interface Maintainer {

    val github: String?

    fun copyWith(github: String? = this.github): Maintainer
}