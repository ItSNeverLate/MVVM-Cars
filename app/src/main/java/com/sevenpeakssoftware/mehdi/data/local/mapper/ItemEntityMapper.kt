package com.sevenpeakssoftware.mehdi.data.local.mapper

import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity
import com.sevenpeakssoftware.mehdi.domain.model.Item
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
object ItemEntityMapper : Mapper<ItemEntity, Item> {

    override fun toModel(entity: ItemEntity) = Item(
        description = entity.description,
        subject = entity.subject,
        type = entity.type
    )

    override fun fromModel(model: Item) =
        ItemEntity(
            description = model.description,
            subject = model.subject,
            type = model.type
        )

    override fun fromModelList(list: List<Item>): List<ItemEntity> = list.map {
        fromModel(it)
    }

    override fun toModelList(list: List<ItemEntity>): List<Item> = list.map {
        toModel(it)
    }
}