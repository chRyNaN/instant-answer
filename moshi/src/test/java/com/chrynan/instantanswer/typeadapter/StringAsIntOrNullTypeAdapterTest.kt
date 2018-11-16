package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.StringAsIntOrNull
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import org.amshove.kluent.shouldEqual
import org.junit.Test

class StringAsIntOrNullTypeAdapterTest {

    private val moshi = Moshi.Builder()
        .add(StringAsIntOrNullTypeAdapter())
        .build()

    @Test
    fun stringAsIntOrNullFromJsonShouldReturnInt() {
        val json = "{\"string\":\"0\"}"
        val adapter = moshi.adapter(TestModel::class.java)

        adapter.fromJson(json) shouldEqual TestModel(0)
    }

    @Test
    fun stringAsIntOrNullFromJsonShouldReturnNull() {
        val json = "{\"string\":\"\"}"
        val adapter = moshi.adapter(TestModel::class.java)

        adapter.fromJson(json) shouldEqual TestModel(null)
    }
}

data class TestModel(@field:Json(name = "string") @StringAsIntOrNull val i: Int? = null)