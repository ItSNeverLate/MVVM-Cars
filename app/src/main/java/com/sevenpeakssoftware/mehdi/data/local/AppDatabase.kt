package com.sevenpeakssoftware.mehdi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sevenpeakssoftware.mehdi.data.local.dao.ArticleDao
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity

@Database(entities = [ArticleEntity::class, ItemEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "app_db"
    }

    abstract fun articleDao(): ArticleDao
}