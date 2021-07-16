package com.sevenpeakssoftware.mehdi.data.remote.mapper

import com.sevenpeakssoftware.mehdi.data.remote.dto.ItemDto
import com.sevenpeakssoftware.mehdi.domain.model.Item
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

object ItemDtoMapper : Mapper<ItemDto, Item> {

    override fun toModel(itemDto: ItemDto) = Item(
        description = itemDto.description,
        subject = itemDto.subject,
        type = itemDto.type
    )

    override fun fromModel(item: Item) =
        ItemDto(
            description = item.description,
            subject = item.subject,
            type = item.type
        )
}