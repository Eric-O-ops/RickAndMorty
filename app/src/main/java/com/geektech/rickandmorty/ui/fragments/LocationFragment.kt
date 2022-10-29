package com.geektech.rickandmorty.ui.fragments

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentLocationBinding
import com.geektech.rickandmorty.ui.LocationViewModel
import com.geektech.rickandmorty.ui.adapters.LocationAdapter

class LocationFragment
    : BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter: LocationAdapter = LocationAdapter()

    override fun initialization() {
        binding.characterRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchLocation().observe(viewLifecycleOwner) {
            locationAdapter.submitList(it.results)
            Log.e("Location", "setupObserve:${it.results}")
        }
    }
}