package com.app.androidev.utils.base

import android.widget.ImageView
import com.app.androidev.R
import com.bumptech.glide.Glide

fun ImageView.loadRect(urlImage: String?) {
    Glide.with(context)
        .load(urlImage)
        .placeholder(R.drawable.ic_launcher_background)
        .centerCrop()
        .into(this)
}