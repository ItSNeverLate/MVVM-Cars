package com.sevenpeakssoftware.mehdi.domain.repository

import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getArticles(): Flow<Resource<List<Article>>>
}