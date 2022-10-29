package com.geektech.rickandmorty.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geektech.rickandmorty.databinding.ItemChracterBinding
import com.geektech.rickandmorty.model.character.CharacterModel

class CharacterAdapter : ListAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemChracterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterModel?) {
            binding.name.text = item?.name
            binding.status.text = item?.status
            binding.species.text = item?.species
            binding.indicator.setCardBackgroundColor(indicator(item))
            binding.image.load(item?.image)
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

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}