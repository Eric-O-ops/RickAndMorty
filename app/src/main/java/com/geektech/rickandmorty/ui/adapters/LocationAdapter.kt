package com.geektech.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.rickandmorty.base.BaseDiffUtilItemCallback
import com.geektech.rickandmorty.databinding.ItemLocationBinding
import com.geektech.rickandmorty.model.location.LocationModel

class LocationAdapter : ListAdapter<LocationModel, LocationAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: LocationModel?) {
            binding.name.text = item?.name
            binding.type.text = item?.type
            binding.dimension.text = item?.dimension
            binding.created.text = item?.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}