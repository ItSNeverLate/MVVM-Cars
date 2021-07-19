package com.sevenpeakssoftware.mehdi.data.local


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class AppDatabaseTest {

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
    fun articleDaoInitialization() {
        assertThat(dao).isInstanceOf(ArticleDao::class.java)
    }
}