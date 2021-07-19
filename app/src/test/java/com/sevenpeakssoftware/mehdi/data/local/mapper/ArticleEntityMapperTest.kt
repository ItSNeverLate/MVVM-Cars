package com.sevenpeakssoftware.mehdi.data.local.mapper

import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.ItemEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.relation.ArticleWithItems
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.model.Item
import org.junit.Test

class ArticleEntityMapperTest {

    @Test
    fun `convert Article Model to Article Entity`() {
        val items = listOf(Item("Description", "Subject", "Type"))
        val articleModel = Article(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), items, 0, 0)
        val articleEntity = ArticleEntityMapper.fromModel(articleModel)

        assertThat(articleEntity.items[0].description).isEqualTo("Description")
    }

    @Test
    fun `convert Article List Model to Article List Entity`() {
        val items1 = listOf(Item("Description1", "Subject", "Type"))
        val articleModel1 = Article(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), items1, 0, 0)
        val items2 = listOf(Item("Description2", "Subject", "Type"))
        val articleModel2 = Article(2, "Article 2", "29.12.2017 15:30", "", "", listOf(), items2, 0, 0)
        val articleListModel = listOf(articleModel1,articleModel2)
        val articleListEntity = ArticleEntityMapper.fromModelList(articleListModel)

        assertThat(articleListEntity[1].items[0].description).isEqualTo("Description2")
    }

    @Test
    fun `convert Article Entity to Article Model`() {
        val articleEntity = ArticleEntity(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), 0, 0)
        val itemsEntity = listOf(ItemEntity(1,123,"Description", "Subject", "Type"))
        val articleWithItemsEntity = ArticleWithItems(articleEntity,itemsEntity)
        val articleModel = ArticleEntityMapper.toModel(articleWithItemsEntity)

        assertThat(articleModel.content[0].description).isEqualTo("Description")
    }

    @Test
    fun `convert Article List Entity to Article List Model`() {
        val articleEntity1 = ArticleEntity(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), 0, 0)
        val itemsEntity1 = listOf(ItemEntity(1,123,"Description1", "Subject", "Type"))
        val articleWithItems1 = ArticleWithItems(articleEntity1,itemsEntity1)
        val articleEntity2 = ArticleEntity(2, "Article 1", "29.12.2017 15:30", "", "", listOf(), 0, 0)
        val itemsEntity2 = listOf(ItemEntity(2,346,"Description2", "Subject", "Type"))
        val articleWithItems2 = ArticleWithItems(articleEntity2,itemsEntity2)
        val articleWithItemsListEntity = listOf(articleWithItems1,articleWithItems2)
        val articleListModel = ArticleEntityMapper.toModelList(articleWithItemsListEntity)

        assertThat(articleListModel[1].content[0].description).isEqualTo("Description2")
    }
}