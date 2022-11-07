package com.geektech.rickandmorty.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.rickandmorty.base.BaseDiffUtilItemCallback
import com.geektech.rickandmorty.databinding.ItemChracterBinding
import com.geektech.rickandmorty.model.character.CharacterModel

class CharacterAdapter(
    private val shortClick: OnClickCharacter) :
    PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemChracterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterModel?, listener: OnClickCharacter) = with(binding) {
            itemCharacterName.text = item?.name
            itemCharacterStatus.text = item?.status
            itemCharacterSpecies.text = item?.species
            itemCharacterNameFirstSeen.text = item?.origin?.name
            itemCharacterNameLocation.text = item?.location?.name
            itemCharacterIndicator.setCardBackgroundColor(indicator(item))
            Glide.with(itemCharacterImage).load(item?.image).into(itemCharacterImage)

            itemView.setOnClickListener {
                listener.shortClick(item?.id!!)
            }
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
        holder.onBind(getItem(position), shortClick)
    }
}

interface OnClickCharacter {
    fun shortClick(idModel: Int)
}