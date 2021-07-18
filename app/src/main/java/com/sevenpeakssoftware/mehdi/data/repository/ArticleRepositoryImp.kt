package com.sevenpeakssoftware.mehdi.data.repository

import androidx.room.withTransaction
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.local.mapper.ArticleEntityMapper
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import com.sevenpeakssoftware.mehdi.data.remote.mapper.ArticleDtoMapper
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.util.networkBoundResource
import kotlinx.coroutines.flow.map

class ArticleRepositoryImp constructor(
    private val service: AppService,
    private val db: AppDatabase,
) : ArticleRepository {
    private val articleDao = db.articleDao()
    private val itemDao = db.itemDao()

    override fun getArticles() = networkBoundResource(
        query = {
            articleDao.getAllArticles().map {
                ArticleEntityMapper.toModelList(it)
            }
        },
        fetch = {
            service.getArticles()
        },
        saveFetchResult = { result ->
            db.withTransaction {
                articleDao.deleteAllArticles()
                val articles = ArticleDtoMapper.toModelList(result.content)
                val articlesItems = ArticleEntityMapper.fromModelList(articles)
                for (articleItem in articlesItems) {
                    articleDao.insertArticle(articleItem.article)
                    for(item in articleItem.items)
                    itemDao.insertItem(item.copy(articleId = articleItem.article.id))
                }
            }
        }
    )
}