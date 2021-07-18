package com.sevenpeakssoftware.mehdi.di.module

import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import com.sevenpeakssoftware.mehdi.domain.useCase.articles.GetArticlesUseCase
import com.sevenpeakssoftware.mehdi.domain.useCase.articles.GetArticlesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetArticlesUseCase(articleRepository: ArticleRepository): GetArticlesUseCase =
        GetArticlesUseCaseImpl(articleRepository)
}