package com.sevenpeakssoftware.mehdi.data.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import mockwebserver3.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

class ArticleRepositoryImpTest{

    private lateinit var mockAppService: MockWebServer
    private lateinit var db: AppDatabase
    private lateinit var dao: ArticleDao

    @Before
    fun setup() {
        mockAppService = MockWebServer()
        mockAppService.start(8080)

        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = db.articleDao()
    }

    @After
    fun teardown() {
        mockAppService.shutdown()

        db.close()
    }
}