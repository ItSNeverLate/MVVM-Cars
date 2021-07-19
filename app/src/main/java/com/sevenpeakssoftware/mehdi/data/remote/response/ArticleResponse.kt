package com.sevenpeakssoftware.mehdi.data.remote.response

import com.sevenpeakssoftware.mehdi.data.remote.dto.ArticleDto

data class ArticleResponse(
    val content: List<ArticleDto>,
    val serverTime: Int,
    val status: String,
)