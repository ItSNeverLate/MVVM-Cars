package com.sevenpeakssoftware.mehdi.data.remote.dto

data class ArticleDto(
    val id: Long,
    val title: String,
    val dateTime: String,
    val image: String,
    val ingress: String,
//    val tags: List<String>,
//    val content: List<ItemDto>,
    val created: Long,
    val changed: Long,
)