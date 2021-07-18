package com.sevenpeakssoftware.mehdi.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.YEAR

object DateUtils {

    /**
     * Dates should use next format:
     *    ● If within current year: “[day] [month], [time]”. For example: “16 March, 12:34”
     *    ● If within different year: “[day] [month] [year], [time]”. For example: “20 December 2017, 21:43”
     * Time should follow system settings for 12h / 24h format, for example, “09:43 PM” vs “21:43”.
     */
    fun getFormattedDate(dateStr: String, datePattern: String? = "dd.MM.yyyy HH:mm"): String? {
        val date: Date? = SimpleDateFormat(datePattern).parse(dateStr)

        return date?.let {
            date
            val currentYear = Calendar.getInstance().get(YEAR)
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = date.time
            val dateYear = calendar.get(YEAR)
            // System settings for 12h / 24h format
            val defaultTimePattern = SimpleDateFormat().toPattern().split(',')[1];
            val datePattern = when (currentYear) {
                dateYear -> "d MMMM"
                else -> "d MMMM yyyy"
            }
            val pattern = "$datePattern,$defaultTimePattern"
            SimpleDateFormat(pattern).format(date)
        }
    }
}
