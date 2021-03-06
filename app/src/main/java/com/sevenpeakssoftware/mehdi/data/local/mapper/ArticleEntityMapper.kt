package com.sevenpeakssoftware.mehdi.data.local.mapper

import com.sevenpeakssoftware.mehdi.data.local.entity.ArticleEntity
import com.sevenpeakssoftware.mehdi.data.local.entity.relation.ArticleWithItems
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.domain.util.Mapper

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
object ArticleEntityMapper : Mapper<ArticleWithItems, Article> {

    override fun toModel(articleWithEntity: ArticleWithItems) = Article(
        id = articleWithEntity.article.id,
        title = articleWithEntity.article.title,
        dateTime = articleWithEntity.article.dateTime,
        image = articleWithEntity.article.image,
        ingress = articleWithEntity.article.ingress,
        tags = articleWithEntity.article.tags,
        content = ItemEntityMapper.toModelList(articleWithEntity.items),
        created = articleWithEntity.article.created,
        changed = articleWithEntity.article.changed,
    )

    override fun fromModel(model: Article) =
        ArticleWithItems(
            ArticleEntity(
                id = model.id,
                title = model.title,
                dateTime = model.dateTime,
                image = model.image,
                ingress = model.ingress,
                tags = model.tags,
                created = model.created,
                changed = model.changed
            ),
            ItemEntityMapper.fromModelList(model.content)
        )

    override fun fromModelList(list: List<Article>): List<ArticleWithItems> =
        list.map {
            fromModel(it)
        }

    override fun toModelList(list: List<ArticleWithItems>): List<Article> = list.map {
        toModel(it)
    }
}