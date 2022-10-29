package com.geektech.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmorty.databinding.ItemEpisodeBinding
import com.geektech.rickandmorty.model.episode.EpisodeModel

class EpisodeAdapter : ListAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EpisodeModel?) {
            binding.name.text = item?.name
            binding.episode.text = item?.episode
            binding.airDate.text = item?.airDate
            binding.created.text = item?.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}