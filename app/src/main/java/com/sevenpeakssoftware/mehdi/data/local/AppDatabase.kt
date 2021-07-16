package com.sevenpeakssoftware.mehdi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class],version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}