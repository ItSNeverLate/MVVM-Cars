package com.sevenpeakssoftware.mehdi.domain.useCase.articles

import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetArticlesUseCase {
    operator fun invoke(): Flow<Resource<List<Article>>>
}