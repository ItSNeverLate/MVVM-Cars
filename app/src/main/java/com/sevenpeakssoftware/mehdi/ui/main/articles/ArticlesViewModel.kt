package com.sevenpeakssoftware.mehdi.ui.main.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sevenpeakssoftware.mehdi.data.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    repository: ArticleRepository
) : ViewModel() {

    val articles = repository.getArticles().asLiveData()
}