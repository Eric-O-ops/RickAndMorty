package com.geektech.rickandmorty.ui.fragments.character

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.data.network.internetconection.InternetHelper
import com.geektech.rickandmorty.databinding.FragmentCharacterBinding
import com.geektech.rickandmorty.ui.adapters.CharacterAdapter

class CharacterFragment
    : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter: CharacterAdapter = CharacterAdapter()

    override fun initialization() {
        binding.characterRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserves() {
        if (InternetHelper.statusInternetConnection(requireContext())) {
            viewModel.fetchCharacter().observe(viewLifecycleOwner) {
                characterAdapter.submitList(it.results)
                Log.e("Character", "setupObserveWithInternet:${it.results}")
            }
        }else {
            viewModel.getAllFromRoom()?.observe(viewLifecycleOwner) {
                characterAdapter.submitList(it)
                Log.e("Character", "setupObserveWithWithoutInternet:${it}")
            }
        }
    }
}
