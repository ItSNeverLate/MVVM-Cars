package com.sevenpeakssoftware.mehdi.domain.useCase.implemantation

import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.domain.useCase.abstraction.GetArticlesUseCase
import com.sevenpeakssoftware.mehdi.domain.util.Result

class GetArticlesUseCaseImpl(private val articleRepository: ArticleRepository) :
    GetArticlesUseCase {
    override fun invoke(): Result<List<Article>> = articleRepository.getArticles()
}