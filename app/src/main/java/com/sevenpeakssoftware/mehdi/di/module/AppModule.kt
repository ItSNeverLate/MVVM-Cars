package com.sevenpeakssoftware.mehdi.di.module

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase
import com.sevenpeakssoftware.mehdi.data.local.AppDatabase.Companion.DB_NAME
import com.sevenpeakssoftware.mehdi.data.remote.AppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(AppService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAppService(retrofit: Retrofit): AppService =
        retrofit.create(AppService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, DB_NAME)
            .build()
}