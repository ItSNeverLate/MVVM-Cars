package com.sevenpeakssoftware.mehdi.presentation.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.util.*

class DateTimeUtilsTest {

    @Test
    fun `date in the current year_returns formatted date without year`() {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val result = DateTimeUtils.getFormattedDateTime("29.11.${currentYear} 15:12")
        assertThat(result)
            .startsWith("29 November,")
    }

    @Test
    fun `date in the other years_returns formatted date with year`() {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR) - 1
        val result = DateTimeUtils.getFormattedDateTime("29.11.${currentYear} 15:12")
        assertThat(result)
            .startsWith("29 November ${currentYear},")
    }
}