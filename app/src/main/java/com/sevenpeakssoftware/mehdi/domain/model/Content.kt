package com.sevenpeakssoftware.mehdi.domain.model

import androidx.room.Entity

@Entity(tableName = "contents")
data class Content(
    val description: String,
    val subject: String,
    val type: String
)