package com.sevenpeakssoftware.mehdi.data.local

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ConvertersTest {

    @Test
    fun `converting String List to Json, and the result to String List_isEqual`() {
        val data = listOf("Some String", "Other String")
        val json = Convertors.fromStringList(data)
        val result = Convertors.toStringList(json)

        assertThat(result).isEqualTo(data)
    }
}