package com.sevenpeakssoftware.mehdi.data.remote.mapper

import com.sevenpeakssoftware.mehdi.data.remote.dto.ArticleDto
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

object ArticleDtoMapper : Mapper<ArticleDto, Article> {

    override fun toModel(articleDto: ArticleDto) = Article(
        id = articleDto.id,
        title = articleDto.title,
        dateTime = articleDto.dateTime,
        image = articleDto.image,
        ingress = articleDto.ingress,
//        tags = articleDto.tags,
//        content = articleDto.content.map {
//            ItemDtoMapper.toModel(it)
//        },
        created = articleDto.created,
        changed = articleDto.changed,
    )

    override fun fromModel(model: Article) =
        ArticleDto(
            id = model.id,
            title = model.title,
            dateTime = model.dateTime,
            image = model.image,
            ingress = model.ingress,
//            tags = model.tags,
//            content = model.content.map {
//                ItemDtoMapper.fromModel(it)
//            },
            created = model.created,
            changed = model.changed,
        )
}