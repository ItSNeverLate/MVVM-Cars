package com.sevenpeakssoftware.mehdi.data.local.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity

data class ArticleWithItems(
    @Embedded
    val article: ArticleEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "articleId",
        entity = ItemEntity::class
    )
    val items: List<ItemEntity>,
)