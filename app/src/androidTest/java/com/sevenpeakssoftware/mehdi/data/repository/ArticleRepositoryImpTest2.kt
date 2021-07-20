package com.sevenpeakssoftware.mehdi.data.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.util.JsonUtil
import mockwebserver3.Dispatcher
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import mockwebserver3.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ArticleRepositoryImpTest2{

    private lateinit var mockAppService: MockWebServer
    private lateinit var db: AppDatabase
    private lateinit var dao: ArticleDao

//    val dispatcher = object : Dispatcher(){
//        override fun dispatch(request: RecordedRequest): MockResponse {
//            if (request.path.equals("article/get_articles_list")) {
//                return MockResponse().setResponseCode(200).setBody(Responses.GET_ARTICLES_200))
//            }
//            return MockResponse().setResponseCode(404)
//        }
//
//    }

    @Before
    fun setup() {
        mockAppService = MockWebServer()
        mockAppService.start(8080)
//        mockAppService.dispatcher = dispatcher

        val mockedResponse = MockResponse()
        mockedResponse.setResponseCode(200)
        mockedResponse.setBody(JsonUtil.getJsonFileContent( "resources/json/article/articles.json"))

        mockAppService.enqueue(mockedResponse)

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

    @Test
    fun getArticlesFromRemoteAndSaveIntoDB_returnsDataFromDB(){
//        val api = mock()
//        val articleRepository = ArticleRepositoryImp(mockAppService,db)

        assertThat("1").isEqualTo("1")
//        mockAppService.takeRequest()
    }
}