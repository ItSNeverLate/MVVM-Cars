package com.sevenpeakssoftware.mehdi.data.local.mapper

import com.google.common.truth.Truth
import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity
import com.sevenpeakssoftware.mehdi.domain.model.Item
import org.junit.Test

class ItemEntityMapperTest {

    @Test
    fun `convert Item Model to Item Entity`() {
        val itemModel = Item("Description", "Subject", "Type")
        val itemEntity = ItemEntityMapper.fromModel(itemModel)

        Truth.assertThat(itemEntity.description).isEqualTo("Description")
    }

    @Test
    fun `convert Item List Model to Item List Entity`() {
        val itemModel1 = Item("Description1", "Subject", "Type")
        val itemModel2 = Item("Description2", "Subject", "Type")
        val itemListModel = listOf(itemModel1, itemModel2)
        val itemListEntity = ItemEntityMapper.fromModelList(itemListModel)

        Truth.assertThat(itemListEntity[1].description).isEqualTo("Description2")
    }

    @Test
    fun `convert Item Entity to Item Model`() {
        val itemEntity = ItemEntity(1, 123, "Description", "Subject", "Type")
        val itemModel = ItemEntityMapper.toModel(itemEntity)

        Truth.assertThat(itemModel.description).isEqualTo("Description")
    }

    @Test
    fun `convert Item List Entity to Item List Model`() {
        val itemEntity1 = ItemEntity(1, 123, "Description1", "Subject", "Type")
        val itemEntity2 = ItemEntity(2, 346, "Description2", "Subject", "Type")
        val itemListEntity = listOf(itemEntity1, itemEntity2)
        val itemListModel = ItemEntityMapper.toModelList(itemListEntity)

        Truth.assertThat(itemListModel[1].description).isEqualTo("Description2")
    }
}