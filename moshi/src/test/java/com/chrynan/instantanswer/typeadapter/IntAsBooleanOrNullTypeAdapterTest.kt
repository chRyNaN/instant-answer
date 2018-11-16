package com.chrynan.instantanswer.typeadapter

import com.chrynan.instantanswer.IntAsBooleanOrNull
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import org.amshove.kluent.shouldEqual
import org.junit.Test

class IntAsBooleanOrNullTypeAdapterTest {

    private val moshi = Moshi.Builder()
        .add(IntAsBooleanOrNullTypeAdapter())
        .build()

    @Test
    fun intAsBooleanOrNullFromJsonShouldReturnBoolean() {
        val json = "{\"int\":\"0\"}"
        val adapter = moshi.adapter(TestBooleanModel::class.java)

        adapter.fromJson(json) shouldEqual TestBooleanModel(false)
    }

    // TODO get this test to work @Test
    fun intAsBooleanOrNullFromJsonShouldReturnNull() {
        val json = "{\"int\":\"\"}"
        val adapter = moshi.adapter(TestBooleanModel::class.java)

        adapter.fromJson(json) shouldEqual TestBooleanModel(null)
    }
}

data class TestBooleanModel(@field:Json(name = "int") @IntAsBooleanOrNull val b: Boolean? = null)