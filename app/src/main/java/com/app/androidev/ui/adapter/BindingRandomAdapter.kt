package com.app.androidev.ui.adapter

import com.app.androidev.R
import com.app.androidev.app.model.ResponseRandom
import com.app.androidev.utils.adapter.ItemViewHolder

class BindingRandomAdapter(val response: ResponseRandom) : ItemViewHolder {
    override val layoutId: Int = R.layout.random_layout
    override val viewType: Int = -3
}