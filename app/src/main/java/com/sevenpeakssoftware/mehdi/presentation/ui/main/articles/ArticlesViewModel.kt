package com.sevenpeakssoftware.mehdi.presentation.ui.main.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.domain.useCase.articles.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    repository: ArticleRepository,
    getArticlesUseCase: GetArticlesUseCase,
) : ViewModel() {

    //    val articles = repository.getArticles().asLiveData()
    val articles = getArticlesUseCase.invoke().asLiveData()
}