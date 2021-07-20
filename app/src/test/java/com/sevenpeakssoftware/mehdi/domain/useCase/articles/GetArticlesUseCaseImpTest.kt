package com.sevenpeakssoftware.mehdi.domain.useCase.articles

import com.google.common.truth.Truth
import com.sevenpeakssoftware.mehdi.data.repository.FakeArticleRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetArticlesUseCaseImpTest {

    private lateinit var useCase: GetArticlesUseCase

    @Before
    fun setup() {
        useCase = GetArticlesUseCaseImpl(FakeArticleRepository())
    }

    @Test
    fun `get articles returns Article List`() = runBlockingTest {
        val result = useCase.invoke().first()
        Truth.assertThat(result.data?.get(1)?.id).isEqualTo(30)
    }
}