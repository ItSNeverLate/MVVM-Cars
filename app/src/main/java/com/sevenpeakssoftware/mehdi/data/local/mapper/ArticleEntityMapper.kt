package com.sevenpeakssoftware.mehdi.data.local.mapper

import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.remote.mapper.ItemDtoMapper
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

object ArticleEntityMapper : Mapper<ArticleEntity, Article> {

    override fun toModel(articleEntity: ArticleEntity) = Article(
        id = articleEntity.id,
        title = articleEntity.title,
        dateTime = articleEntity.dateTime,
        image = articleEntity.image,
        ingress = articleEntity.ingress,
//        tags = articleEntity.tags,
//        content = articleEntity.content.map {
//            ItemEntityMapper.toModel(it)
//        },
        created = articleEntity.created,
        changed = articleEntity.changed,
    )

    override fun fromModel(model: Article) =
        ArticleEntity(
            id = model.id,
            title = model.title,
            dateTime = model.dateTime,
            image = model.image,
            ingress = model.ingress,
//            tags = model.tags,
//            content = model.content.map {
//                ItemEntityMapper.fromModel(it)
//            },
            created = model.created,
            changed = model.changed,
        )
}