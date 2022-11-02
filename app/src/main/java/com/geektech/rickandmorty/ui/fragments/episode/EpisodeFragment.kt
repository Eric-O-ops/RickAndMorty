package com.geektech.rickandmorty.ui.fragments.episode

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.data.network.internetconection.InternetHelper
import com.geektech.rickandmorty.databinding.FragmentEpisodeBinding
import com.geektech.rickandmorty.ui.adapters.EpisodeAdapter

class EpisodeFragment
    : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding: FragmentEpisodeBinding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter: EpisodeAdapter = EpisodeAdapter()

    override fun initialization() {
        binding.characterRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserves() {
        if (InternetHelper.statusInternetConnection(requireContext())) {
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it.results)
                Log.e("Episode", "setupObserveWithInternet:${it.results}")
            }
        }else {
            viewModel.getAllFromRoom()?.observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it)
                Log.e("Episode", "setupObserveWithWithoutInternet:${it}")
            }
        }
    }
}