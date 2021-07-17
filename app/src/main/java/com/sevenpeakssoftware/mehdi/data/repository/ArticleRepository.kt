package com.sevenpeakssoftware.mehdi.data.repository

import androidx.room.withTransaction
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import com.sevenpeakssoftware.mehdi.util.networkBoundResource
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val service: AppService,
    private val db: AppDatabase
) {
    private val articleDao = db.articleDao()

    fun getArticles() = networkBoundResource(
        query = {
            articleDao.getAllArticles()
        },
        fetch = {
            service.getArticles()
        },
        saveFetchResult = { result ->
            db.withTransaction {
                articleDao.deleteAllArticles()
                articleDao.insertArticles(result.content)
            }
        }
    )
}