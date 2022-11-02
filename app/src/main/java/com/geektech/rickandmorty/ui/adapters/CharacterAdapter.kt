package com.geektech.rickandmorty.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.rickandmorty.base.BaseDiffUtilItemCallback
import com.geektech.rickandmorty.databinding.ItemChracterBinding
import com.geektech.rickandmorty.model.character.CharacterModel

class CharacterAdapter :
    ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemChracterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterModel?) = with(binding) {
            name.text = item?.name
            status.text = item?.status
            species.text = item?.species
            nameFirstSeen.text = item?.origin?.name
            nameLocation.text = item?.location?.name
            indicator.setCardBackgroundColor(indicator(item))
            image.load(item?.image)
        }

        private fun indicator(item: CharacterModel?): Int {
            return when (item?.status) {

                "Alive" -> {
                    Color.GREEN
                }
                "Dead" -> {
                    Color.RED
                }
                else -> {
                    Color.GRAY
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChracterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}