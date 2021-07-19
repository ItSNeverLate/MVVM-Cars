package com.sevenpeakssoftware.mehdi.data.remote.mapper

import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.mehdi.data.remote.dto.ArticleDto
import com.sevenpeakssoftware.mehdi.data.remote.dto.ItemDto
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.model.Item
import org.junit.Test

class ArticleDtoMapperTest {

    @Test
    fun `convert Article Model to Article Dto`() {
        val items = listOf(Item("Description", "Subject", "Type"))
        val articleModel =
            Article(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), items, 0, 0)
        val articleDto = ArticleDtoMapper.fromModel(articleModel)

        assertThat(articleDto.content[0].description).isEqualTo("Description")
    }

    @Test
    fun `convert Article List Model to Article List Dto`() {
        val items1 = listOf(Item("Description1", "Subject", "Type"))
        val articleModel1 =
            Article(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), items1, 0, 0)
        val items2 = listOf(Item("Description2", "Subject", "Type"))
        val articleModel2 =
            Article(2, "Article 2", "29.12.2017 15:30", "", "", listOf(), items2, 0, 0)
        val articleListModel = listOf(articleModel1, articleModel2)
        val articleListDto = ArticleDtoMapper.fromModelList(articleListModel)

        assertThat(articleListDto[1].content[0].description).isEqualTo("Description2")
    }

    @Test
    fun `convert Article Dto to Article Model`() {
        val itemsDto = listOf(ItemDto("Description", "Subject", "Type"))
        val articleDto =
            ArticleDto(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), itemsDto, 0, 0)
        val articleModel = ArticleDtoMapper.toModel(articleDto)

        assertThat(articleModel.content[0].description).isEqualTo("Description")
    }

    @Test
    fun `convert Article List Dto to Article List Model`() {
        val itemsDto1 = listOf(ItemDto("Description1", "Subject", "Type"))
        val articleDto1 =
            ArticleDto(1, "Article 1", "29.12.2017 15:30", "", "", listOf(), itemsDto1, 0, 0)
        val itemsDto2 = listOf(ItemDto("Description2", "Subject", "Type"))
        val articleDto2 =
            ArticleDto(2, "Article 1", "29.12.2017 15:30", "", "", listOf(), itemsDto2, 0, 0)
        val articleListDto = listOf(articleDto1, articleDto2)
        val articleListModel = ArticleDtoMapper.toModelList(articleListDto)

        assertThat(articleListModel[1].content[0].description).isEqualTo("Description2")
    }
}