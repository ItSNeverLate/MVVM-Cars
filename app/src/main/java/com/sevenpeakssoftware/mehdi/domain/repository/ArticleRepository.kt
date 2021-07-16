package com.sevenpeakssoftware.mehdi.domain.repository

import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getArticles(): Result<List<Article>>

    fun getLocalArticles(): Flow<List<ArticleEntity>>
}