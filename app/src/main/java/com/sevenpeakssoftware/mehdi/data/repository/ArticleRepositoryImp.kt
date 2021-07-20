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

                val entities = ArticleEntityMapper.fromModelList(articles)
                for (entity in entities) {
                    articleDao.insert(entity.article, entity.items)
                }

            }
        }
    )
}