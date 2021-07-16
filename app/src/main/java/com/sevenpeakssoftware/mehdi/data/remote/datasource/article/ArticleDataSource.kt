package com.sevenpeakssoftware.mehdi.data.remote.datasource.article

import com.sevenpeakssoftware.mehdi.data.remote.dto.ArticleDto
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Result

interface ArticleDataSource {

    suspend fun getArticles(): Result<List<Article>>
}