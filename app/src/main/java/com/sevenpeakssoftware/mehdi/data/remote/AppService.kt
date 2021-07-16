package com.sevenpeakssoftware.mehdi.data.remote

import com.sevenpeakssoftware.mehdi.data.remote.dto.ArticleDto
import com.sevenpeakssoftware.mehdi.domain.model.Article
import retrofit2.Response
import retrofit2.http.GET

interface AppService {

    @GET("/users")
    suspend fun getArticles(): Response<List<Article>>
}