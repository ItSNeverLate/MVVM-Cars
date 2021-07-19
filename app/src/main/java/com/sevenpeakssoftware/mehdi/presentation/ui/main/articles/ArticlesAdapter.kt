package com.sevenpeakssoftware.mehdi.presentation.ui.main.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sevenpeakssoftware.mehdi.databinding.ItemArticleBinding
import com.sevenpeakssoftware.mehdi.domain.model.Article
import com.sevenpeakssoftware.mehdi.presentation.util.DateTimeUtils

class ArticlesAdapter :
    ListAdapter<Article, ArticlesAdapter.ArticleViewHolder>(ArticleComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding: ItemArticleBinding =
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class ArticleViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.apply {
                Glide.with(itemView)
                    .load(article.image)
                    .into(imageViewLogo)

                textViewTitle.text = article.title
                textViewDate.text = DateTimeUtils.getFormattedDateTime(article.dateTime)
                textViewDescription.text = article.ingress
            }
        }
    }

    class ArticleComparator : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Article, newItem: Article) =
            oldItem == newItem
    }
}