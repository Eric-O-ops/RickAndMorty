package com.geektech.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmorty.base.BaseDiffUtilItemCallback
import com.geektech.rickandmorty.databinding.ItemLocationBinding
import com.geektech.rickandmorty.model.character.CharacterModel
import com.geektech.rickandmorty.model.location.LocationModel

class LocationAdapter(
    private val shortClick: OnClickLocation
) : PagingDataAdapter<LocationModel, LocationAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: LocationModel?, shortClick: OnClickLocation) = with(binding) {
            itemLocationName.text = item?.name
            itemLocationType.text = item?.type
            itemLocationDimension.text = item?.dimension
            itemLocationCreated.text = item?.created

            itemView.setOnClickListener {
                shortClick.shortClick(item?.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), shortClick)
    }
}

interface OnClickLocation {
    fun shortClick(idModel: Int)
}