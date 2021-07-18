package com.sevenpeakssoftware.mehdi.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val dateTime: String,
    val image: String,
    val ingress: String,
    val tags: List<String>,
    val created: Long,
    val changed: Long,
)