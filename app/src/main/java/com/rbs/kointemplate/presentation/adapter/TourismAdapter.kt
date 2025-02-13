package com.rbs.kointemplate.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rbs.kointemplate.databinding.ItemListTourismBinding
import com.rbs.kointemplate.core.domain.model.Tourism

class TourismAdapter : ListAdapter<Tourism, TourismAdapter.ListViewHolder>(DIFF_CALLBACK) {
    var onItemClick: ((Tourism) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemListTourismBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Tourism) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivItemImage)

                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.address

                root.setOnClickListener {
                    onItemClick?.invoke(getItem(bindingAdapterPosition))
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Tourism> =
            object : DiffUtil.ItemCallback<Tourism>() {
                override fun areItemsTheSame(oldItem: Tourism, newItem: Tourism): Boolean = oldItem.tourismId == newItem.tourismId

                override fun areContentsTheSame(oldItem: Tourism, newItem: Tourism): Boolean = oldItem == newItem
            }
    }
}