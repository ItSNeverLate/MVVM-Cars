package com.sevenpeakssoftware.mehdi.domain.useCase.articles

import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesUseCaseImpl @Inject constructor(private val articleRepository: ArticleRepository) :
    GetArticlesUseCase {
    override fun invoke(): Flow<Resource<List<Article>>> = articleRepository.getArticles()
}