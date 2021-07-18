package com.sevenpeakssoftware.mehdi.domain.model

data class Article(
    val id: Long,
    val title: String,
    val dateTime: String,
    val image: String,
    val ingress: String,
    val tags: List<String>,
    val content: List<Item>,
    val created: Long,
    val changed: Long,
)