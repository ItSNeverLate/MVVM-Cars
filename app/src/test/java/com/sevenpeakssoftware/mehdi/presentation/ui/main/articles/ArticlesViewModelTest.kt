package com.sevenpeakssoftware.mehdi.presentation.ui.main.articles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.domain.useCase.articles.FakeGetArticlesUseCase
import com.sevenpeakssoftware.mehdi.util.MainCoroutineRule
import com.sevenpeakssoftware.mehdi.util.getOrAwaitValueTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticlesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModal: ArticlesViewModel

    @Before
    fun setup() {
        viewModal = ArticlesViewModel(FakeGetArticlesUseCase())
    }

    @Test
    fun `get articles use case returns Article List`() {
        val result = viewModal.articles.getOrAwaitValueTest()
        assertThat(result.data?.get(1)?.id).isEqualTo(3)
    }
}