package com.geektech.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmorty.base.BaseDiffUtilItemCallback
import com.geektech.rickandmorty.databinding.ItemEpisodeBinding
import com.geektech.rickandmorty.model.episode.EpisodeModel

class EpisodeAdapter(
    private val shortClick: OnClickEpisode
) : PagingDataAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: EpisodeModel?, shortClick: OnClickEpisode) = with(binding) {
            itemEpisodeName.text = item?.name
            itemEpisodeEpisode.text = item?.episode
            itemEpisodeAirDate.text = item?.airDate
            itemEpisodeCreated.text = item?.created

            itemView.setOnClickListener {
                shortClick.shortClick(item?.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), shortClick)
    }
}

interface OnClickEpisode {
    fun shortClick(idModel: Int)
}