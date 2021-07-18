package com.sevenpeakssoftware.mehdi.data.remote.dto

data class ArticleResponse(
    val content: List<ArticleDto>,
    val serverTime: Int,
    val status: String,
)