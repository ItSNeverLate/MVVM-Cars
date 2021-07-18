package com.sevenpeakssoftware.mehdi.data.remote.mapper

import com.sevenpeakssoftware.mehdi.data.remote.dto.ItemDto
import com.sevenpeakssoftware.mehdi.domain.model.Item
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

object ItemDtoMapper : Mapper<ItemDto, Item> {

    override suspend fun toModel(itemDto: ItemDto) = Item(
        description = itemDto.description,
        subject = itemDto.subject,
        type = itemDto.type
    )

    override suspend fun fromModel(item: Item) =
        ItemDto(
            description = item.description,
            subject = item.subject,
            type = item.type
        )

    override suspend fun fromModelList(list: List<Item>): List<ItemDto> =
        list.map { fromModel(it) }

    override suspend fun toModelList(list: List<ItemDto>): List<Item> =
        list.map { toModel(it) }
}