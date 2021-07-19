package com.sevenpeakssoftware.mehdi.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ArticleDaoTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: ArticleDao

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = db.articleDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun insertArticle() = runBlocking {
        val article = ArticleEntity(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), 0, 0)
        dao.insertArticle(article)

        val firstArticle = dao.getAllArticles().first()
        assertThat(firstArticle[0].article).isEqualTo(article)
    }

    @Test
    fun deleteArticles() = runBlocking {
        val article = ArticleEntity(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), 0, 0)
        dao.insertArticle(article)
        dao.deleteAllArticles()

        val firstArticle = dao.getAllArticles().first()
        assertThat(firstArticle).isEqualTo(listOf<ArticleEntity>())
    }

    @Test
    fun insertArticleWithItems() = runBlocking {
        val article = ArticleEntity(10, "Article 1", "29.12.2017 15:30", "", "", listOf(), 0, 0)
        val items = listOf(ItemEntity(null, null, "Description", "Subject", "Type"))
        dao.insert(article, items)

        val firstArticle = dao.getAllArticles().first()
        assertThat(firstArticle[0].items[0].description).isEqualTo(items[0].description)
    }
}