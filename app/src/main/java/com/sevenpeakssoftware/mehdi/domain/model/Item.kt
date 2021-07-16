package com.sevenpeakssoftware.mehdi.domain.model

import androidx.room.Entity

@Entity(tableName = "items")
data class Item(
    val description: String,
    val subject: String,
    val type: String
)