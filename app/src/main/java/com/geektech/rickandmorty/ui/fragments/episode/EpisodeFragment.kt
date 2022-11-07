package com.geektech.rickandmorty.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.data.network.internetconection.InternetHelper
import com.geektech.rickandmorty.databinding.FragmentEpisodeBinding
import com.geektech.rickandmorty.model.episode.EpisodeModel
import com.geektech.rickandmorty.ui.adapters.EpisodeAdapter
import com.geektech.rickandmorty.ui.adapters.OnClickEpisode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class EpisodeFragment
    : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode),
    OnClickEpisode{

    override val binding: FragmentEpisodeBinding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodeAdapter: EpisodeAdapter = EpisodeAdapter(this)

    override fun initialization() {
        binding.episodeRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserves() {
        if (InternetHelper.statusInternetConnection(requireContext())) {
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    episodeAdapter.submitData(it)
                }
            }
        }
    }

    override fun shortClick(idModel: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections
                .actionEpisodeFragmentToDetailEpisodeFragment()
                .setId(idModel)
        )
    }
}