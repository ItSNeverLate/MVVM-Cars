package com.sevenpeakssoftware.mehdi.data.repository

import com.google.gson.Gson
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import com.sevenpeakssoftware.mehdi.data.remote.response.ArticleResponse
import com.sevenpeakssoftware.mehdi.util.JsonUtil

class FakeAppService : AppService {
    private val gson = Gson()

    override suspend fun getArticles(): ArticleResponse {
        return gson.fromJson(JsonUtil.getJsonFileContent("resources/json/article/articles.json"),
            ArticleResponse::class.java)
    }

}