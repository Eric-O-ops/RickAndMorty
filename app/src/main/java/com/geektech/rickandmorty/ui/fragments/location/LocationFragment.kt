package com.geektech.rickandmorty.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.data.network.internetconection.InternetHelper
import com.geektech.rickandmorty.databinding.FragmentLocationBinding
import com.geektech.rickandmorty.ui.adapters.LocationAdapter
import com.geektech.rickandmorty.ui.adapters.OnClickLocation
import kotlinx.coroutines.launch

class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location),
    OnClickLocation {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter: LocationAdapter = LocationAdapter(this)

    override fun initialization() {
        binding.locationRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserves() {
        if (InternetHelper.statusInternetConnection(requireContext())) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    locationAdapter.submitData(it)
                }
            }
        }
    }

    override fun shortClick(idModel: Int) {
        findNavController().navigate(
            LocationFragmentDirections
                .actionLocationFragmentToDetailLocationFragment()
                .setId(idModel)
        )
    }
}