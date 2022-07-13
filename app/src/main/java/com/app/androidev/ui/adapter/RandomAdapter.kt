package com.app.androidev.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.androidev.app.model.ResponseRandom
import com.app.androidev.databinding.RandomLayoutBinding

import com.app.androidev.utils.base.loadRect

class RandomAdapter(var items: MutableList<ResponseRandom>) : RecyclerView.Adapter<RandomAdapter.RandomViewHolder>() {

    class RandomViewHolder(private val binding: RandomLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResponseRandom) {
            binding.imageUrl.loadRect(item.iconUrl)
            binding.value.text = item.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder =
        RandomViewHolder(
            RandomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int =
        items.size

    fun addItems(list: List<ResponseRandom>){
        val positionStart = items.size
        items.addAll(list)
        notifyItemRangeInserted(positionStart, items.size)
    }

}