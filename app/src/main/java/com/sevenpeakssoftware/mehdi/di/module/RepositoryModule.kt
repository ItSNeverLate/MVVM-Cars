package com.sevenpeakssoftware.mehdi.di.module

import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import com.sevenpeakssoftware.mehdi.data.repository.ArticleRepositoryImp
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGetArticleRepository(service: AppService, db: AppDatabase): ArticleRepository =
        ArticleRepositoryImp(service, db)
}