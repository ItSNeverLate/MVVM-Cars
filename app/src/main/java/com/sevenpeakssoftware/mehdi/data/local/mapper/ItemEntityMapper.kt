package com.sevenpeakssoftware.mehdi.data.local.mapper

import com.sevenpeakssoftware.mehdi.domain.model.Item
import com.sevenpeakssoftware.mehdi.domain.model.ItemEntity
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

object ItemEntityMapper : Mapper<ItemEntity, Item> {

    override suspend fun toModel(entity: ItemEntity) = Item(
        description = entity.description,
        subject = entity.subject,
        type = entity.type
    )

    override suspend fun fromModel(model: Item) =
        ItemEntity(
            articleId = 0,
            description = model.description,
            subject = model.subject,
            type = model.type
        )

    override suspend fun fromModelList(list: List<Item>): List<ItemEntity> = list.map {
        fromModel(it)
    }

    override suspend fun toModelList(list: List<ItemEntity>): List<Item> = list.map {
        toModel(it)
    }
}