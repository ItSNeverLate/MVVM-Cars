package com.sevenpeakssoftware.mehdi.data.local.entity

import androidx.room.Entity

@Entity(tableName = "items")
data class ItemEntity(
    val description: String,
    val subject: String,
    val type: String
)