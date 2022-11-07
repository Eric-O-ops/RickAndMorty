package com.geektech.rickandmorty.ui.fragments.character

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.data.network.internetconection.InternetHelper
import com.geektech.rickandmorty.databinding.FragmentCharacterBinding
import com.geektech.rickandmorty.ui.adapters.CharacterAdapter
import com.geektech.rickandmorty.ui.adapters.OnClickCharacter
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.coroutines.launch

class CharacterFragment
    : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character),
    OnClickCharacter {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter: CharacterAdapter = CharacterAdapter(this)

    override fun initialization() {
        binding.characterRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserves() {
        if (InternetHelper.statusInternetConnection(requireContext())) {
            viewModel.fetchCharacter().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    characterAdapter.submitData(it)
                    Log.e("Character", "setupObserveWithInternet:${it}")

                }
            }
        }
    }

    override fun shortClick(idModel: Int) {
        val bottomNavigationView: BottomNavigationView =
            requireActivity().findViewById(R.id.bottom_nav_view)
        bottomNavigationView.visibility = View.VISIBLE
        findNavController().navigate(
            CharacterFragmentDirections
                .actionCharacterFragmentToDetailCharacterFragment()
                .setId(idModel)
        )
    }
}
