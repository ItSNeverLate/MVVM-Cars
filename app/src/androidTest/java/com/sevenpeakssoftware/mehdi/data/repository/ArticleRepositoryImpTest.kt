package com.sevenpeakssoftware.mehdi.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executors

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ArticleRepositoryImpTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var fakeAppService: AppService
    private lateinit var db: AppDatabase

    @Before
    fun setup() {
        fakeAppService = FakeAppService()

        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )   // Notice: for @Transaction, db.withTransaction
            .setTransactionExecutor(Executors.newSingleThreadExecutor())
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun getArticlesFromRemoteAndSaveIntoDB_returnsArticleListSize() = runBlocking {
        val articleRepository = ArticleRepositoryImp(fakeAppService, db)
        val fakeAppServiceArticleListSize = fakeAppService.getArticles().content.size
        // take method makes an flow of { Loading, Success }
        // , and we will consume the Success, for we use last one
        val result = articleRepository.getArticles().take(2).last()

        assertThat(result.data?.size).isEqualTo(fakeAppServiceArticleListSize)
    }
}