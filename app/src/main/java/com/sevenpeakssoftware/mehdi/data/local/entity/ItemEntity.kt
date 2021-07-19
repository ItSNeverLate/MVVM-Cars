package com.sevenpeakssoftware.mehdi.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "items",
    foreignKeys = [
        ForeignKey(entity = ArticleEntity::class,
            parentColumns = ["id"],
            childColumns = ["articleId"],
            onDelete = CASCADE)
    ])
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val articleId: Long? = null,
    val description: String,
    val subject: String,
    val type: String,
)