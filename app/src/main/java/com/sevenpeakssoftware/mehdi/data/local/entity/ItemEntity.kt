package com.sevenpeakssoftware.mehdi.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity

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
    val articleId: Long,
    val description: String,
    val subject: String,
    val type: String,
)