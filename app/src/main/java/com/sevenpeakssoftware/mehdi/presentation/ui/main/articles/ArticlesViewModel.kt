package com.sevenpeakssoftware.mehdi.presentation.ui.main.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sevenpeakssoftware.mehdi.domain.useCase.articles.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    getArticlesUseCase: GetArticlesUseCase,
) : ViewModel() {

    val articles = getArticlesUseCase.invoke().asLiveData()
}