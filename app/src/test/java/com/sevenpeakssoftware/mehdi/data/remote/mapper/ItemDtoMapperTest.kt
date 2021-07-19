package com.sevenpeakssoftware.mehdi.data.remote.mapper

import com.google.common.truth.Truth
import com.sevenpeakssoftware.mehdi.data.remote.dto.ItemDto
import com.sevenpeakssoftware.mehdi.domain.model.Item
import org.junit.Test

class ItemDtoMapperTest {

    @Test
    fun `convert Item Model to Item Dto`() {
        val itemModel = Item("Description", "Subject", "Type")
        val itemDto = ItemDtoMapper.fromModel(itemModel)

        Truth.assertThat(itemDto.description).isEqualTo("Description")
    }

    @Test
    fun `convert Item List Model to Item List Dto`() {
        val itemModel1 = Item("Description1", "Subject", "Type")
        val itemModel2 = Item("Description2", "Subject", "Type")
        val itemListModel = listOf(itemModel1, itemModel2)
        val itemListDto = ItemDtoMapper.fromModelList(itemListModel)

        Truth.assertThat(itemListDto[1].description).isEqualTo("Description2")
    }

    @Test
    fun `convert Item Dto to Item Model`() {
        val itemDto = ItemDto("Description", "Subject", "Type")
        val itemModel = ItemDtoMapper.toModel(itemDto)

        Truth.assertThat(itemModel.description).isEqualTo("Description")
    }

    @Test
    fun `convert Item List Dto to Item List Model`() {
        val itemDto1 = ItemDto("Description1", "Subject", "Type")
        val itemDto2 = ItemDto("Description2", "Subject", "Type")
        val itemListDto = listOf(itemDto1, itemDto2)
        val itemListModel = ItemDtoMapper.toModelList(itemListDto)

        Truth.assertThat(itemListModel[1].description).isEqualTo("Description2")
    }
}