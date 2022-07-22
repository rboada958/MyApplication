package com.app.androidev.ui.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.androidev.app.model.news.ResultsItem
import com.app.androidev.databinding.NewsLayoutBinding

import com.app.androidev.utils.base.loadRect

class NewsAdapter(var items: MutableList<ResultsItem?>,
                  private val listener: OnNewsClickListener? = null
) : RecyclerView.Adapter<NewsAdapter.RandomViewHolder>() {

    class RandomViewHolder(
        private val binding: NewsLayoutBinding,
        private val listener: OnNewsClickListener? = null
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsItem) {
            binding.avatar.loadRect(item.fields!!.thumbnail)
            binding.title.text = item.webTitle
            binding.itemHolder = NewsViewHolder(item) {
                listener?.onNewsClicked(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder =
        RandomViewHolder(
            NewsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) =
        holder.bind(items[position]!!)

    override fun getItemCount(): Int =
        items.size

    fun addItems(list: List<ResultsItem?>){
        val positionStart = items.size
        items.addAll(list)
        notifyItemRangeInserted(positionStart, items.size)
    }

    interface OnNewsClickListener {
        fun onNewsClicked(item: ResultsItem)
    }

}