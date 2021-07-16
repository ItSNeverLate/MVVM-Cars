package com.sevenpeakssoftware.mehdi.data.remote.response

import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity

data class ArticleResponse(
    val content: List<ArticleEntity>,
    val serverTime: Int,
    val status: String
)