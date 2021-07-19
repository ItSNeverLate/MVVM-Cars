package com.sevenpeakssoftware.mehdi.data.local.dao

import androidx.room.*
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.relation.ArticleWithItems
import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<ArticleWithItems>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: ArticleEntity)

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()

    @Transaction
    suspend fun insert(article: ArticleEntity, items: List<ItemEntity>) {
        insertArticle(article)

        for (item in items) {
            insertItem(item.copy(articleId = article.id))
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(items: ItemEntity)
}