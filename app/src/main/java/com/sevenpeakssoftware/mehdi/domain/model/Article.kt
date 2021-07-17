package com.sevenpeakssoftware.mehdi.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey
    val id: Long,
    val title: String,
    val dateTime: String,
    val image: String,
    val ingress: String,
//    val tags: List<String>,
//    val content: List<Item>,
    val created: Long,
    val changed: Long,
)