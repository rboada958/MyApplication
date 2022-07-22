package com.app.androidev.ui.views.adapter

import com.app.androidev.R
import com.app.androidev.app.model.news.ResultsItem
import com.app.androidev.utils.adapter.ItemViewHolder

class NewsViewHolder(val result: ResultsItem, val onClick : ((ResultsItem) -> Unit)? = null) : ItemViewHolder {
    override val layoutId: Int = R.layout.news_layout
    override val viewType: Int = -3
}