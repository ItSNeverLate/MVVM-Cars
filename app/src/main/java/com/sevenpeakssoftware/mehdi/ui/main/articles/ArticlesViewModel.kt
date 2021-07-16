package com.sevenpeakssoftware.mehdi.ui.main.articles

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.room.PrimaryKey
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.remote.datasource.article.ArticleDataSource
import com.sevenpeakssoftware.mehdi.data.repository.ArticleRepositoryImp
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel() {

//    init {
//        clearGrowZoneNumber()  // keep this
//
//        // fetch the full plant list
//        launchDataLoad { plantRepository.tryUpdateRecentPlantsCache() }
//    }

    val articlesFlow: LiveData<List<ArticleEntity>>
        get() = articleRepository.getLocalArticles().asLiveData()


}
