package com.sevenpeakssoftware.mehdi.data.remote.dto

import com.sevenpeakssoftware.mehdi.domain.model.Article

data class ArticleResponse(
    val content: List<Article>,
    val serverTime: Int,
    val status: String
)