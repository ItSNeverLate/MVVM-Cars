package com.sevenpeakssoftware.mehdi.data.repository

import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import com.sevenpeakssoftware.mehdi.data.remote.datasource.article.ArticleDataSource
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.domain.util.Result
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ArticleRepositoryImp
@Inject
constructor(
    private val articleDataSource: ArticleDataSource,
    private val articleDao: ArticleDao
) : ArticleRepository {

//    companion object {
//        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
//    }

    override suspend fun getArticles(): Result<List<Article>> =
        articleDataSource.getArticles()

    override fun getLocalArticles() = articleDao.getAll()


    suspend fun getArticles(): List<Article> {
        val result = articleDataSource.getArticles()
        if (result  == Result.Success)



        val cached: User = userCache.get(userId)
        if (cached != null) {
            return cached
        }
        // This implementation is still suboptimal but better than before.
        // A complete implementation also handles error cases.
        val freshUser = webservice.getUser(userId)
        userCache.put(userId, freshUser)
        return freshUser
    }
}