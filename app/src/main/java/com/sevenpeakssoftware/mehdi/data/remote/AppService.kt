package com.sevenpeakssoftware.mehdi.data.remote

import com.sevenpeakssoftware.mehdi.data.remote.response.ArticleResponse
import retrofit2.http.GET

interface AppService {

    companion object {
        const val BASE_URL = "https://www.apphusetreach.no/application/119267/"
    }

    @GET("article/get_articles_list")
    suspend fun getArticles(): ArticleResponse
}