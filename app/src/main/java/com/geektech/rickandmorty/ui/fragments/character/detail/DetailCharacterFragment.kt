package com.geektech.rickandmorty.ui.fragments.character.detail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentDetailCharacterBinding
import com.geektech.rickandmorty.model.character.CharacterModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailCharacterFragment :
    BaseFragment<FragmentDetailCharacterBinding, DetailCharacterViewModel> (R.layout.fragment_detail_character) {

    override val binding by viewBinding(FragmentDetailCharacterBinding::bind)
    override val viewModel: DetailCharacterViewModel by viewModels()
    private val args by navArgs<DetailCharacterFragmentArgs>()

    override fun setupView() = with(binding) {
        viewModel.fetchDetailCharacter(args.id).observe(viewLifecycleOwner) {
            image.load(it.image)
            name.text = it.name
            status.text = it.status
            indicator.setCardBackgroundColor(indicator(it))
            species.text = it.species
            nameLocation.text = it.location.name
            nameFirstSeen.text = it.origin.name
        }
    }

    private fun indicator(model: CharacterModel?): Int {
        return when (model?.status) {

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