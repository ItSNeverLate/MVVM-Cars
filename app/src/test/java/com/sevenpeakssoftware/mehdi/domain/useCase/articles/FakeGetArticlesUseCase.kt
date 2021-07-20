package com.sevenpeakssoftware.mehdi.domain.useCase.articles

import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.model.Item
import com.sevenpeakssoftware.mehdi.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetArticlesUseCase : GetArticlesUseCase {
    private val articles = listOf(Article(7,
        "Q7 - Greatness starts, when you don't stop.",
        "25.05.2018 14:13",
        "https://www.apphusetreach.no/sites/default/files/audi_q7.jpg",
        "The Audi Q7 is the result of an ambitious idea: never cease to improve.",
        listOf(),
        listOf(Item(
            "The Audi Q7 is masculine, yet exudes lightness. Inside, it offers comfort at the highest level. With even more space for your imagination. The 3.0 TDI engine accelerates this powerhouse as a five-seater starting at an impressive 6.3 seconds from 0 to 100 km/h.",
            "Q7",
            "text"
        )),
        1511968425,
        1534311497),
        Article(3,
            "Q3 - Greatness starts, when you don't stop.",
            "25.05.2018 14:13",
            "https://www.apphusetreach.no/sites/default/files/audi_q7.jpg",
            "The Audi Q3 is the result of an ambitious idea: never cease to improve.",
            listOf(),
            listOf(Item(
                "The Audi Q3 is masculine, yet exudes lightness. Inside, it offers comfort at the highest level. With even more space for your imagination. The 3.0 TDI engine accelerates this powerhouse as a five-seater starting at an impressive 6.3 seconds from 0 to 100 km/h.",
                "Q3",
                "text"
            )),
            1511968420,
            1534311490))
    private val articleFlow = flow<Resource<List<Article>>> {
        if (shouldReturnLoading) {
            emit(Resource.Loading(null))
        }
        if (shouldReturnNetworkError) {
            emit(Resource.Error(Throwable("Error"), null))
        } else {
            emit(Resource.Success(articles))
        }
    }
    private var shouldReturnLoading = false
    private var shouldReturnNetworkError = false

    @Suppress("unused")
    fun setShouldReturnLoading(value: Boolean) {
        shouldReturnLoading = value
    }

    @Suppress("unused")
    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override fun invoke(): Flow<Resource<List<Article>>> = articleFlow
}