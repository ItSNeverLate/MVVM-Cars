package com.sevenpeakssoftware.mehdi.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

object Convertors {

    private val gson = Gson()

    @TypeConverter
    fun toStringList(data: String?): List<String> =
        data?.let {
            val listType = object : TypeToken<List<String>>() {}.type
            return gson.fromJson(it, listType)
        } ?: Collections.emptyList()


    @TypeConverter
    fun fromStringList(list: List<String>): String = gson.toJson(list)
}