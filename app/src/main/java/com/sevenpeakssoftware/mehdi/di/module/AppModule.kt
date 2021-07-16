package com.sevenpeakssoftware.mehdi.di.module

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.sevenpeakssoftware.mehdi.Config.BASE_URL
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import com.sevenpeakssoftware.mehdi.data.remote.datasource.article.ArticleDataSource
import com.sevenpeakssoftware.mehdi.data.remote.datasource.article.ArticleDataSourceImp
import com.sevenpeakssoftware.mehdi.data.repository.ArticleRepositoryImp
import com.sevenpeakssoftware.mehdi.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideWebService(): AppService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(AppService::class.java)

    @Singleton
    @Provides
    fun provideUserDao(@ApplicationContext context: Context): ArticleDao =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
            .build()
            .articleDao()

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(service: AppService): ArticleDataSource =
        ArticleDataSourceImp(service)

    @Singleton
    @Provides
    fun provideArticleRepository(
        articleDataSource: ArticleDataSource,
        articleDao: ArticleDao
    ): ArticleRepository =
        ArticleRepositoryImp(articleDataSource, articleDao)
}
