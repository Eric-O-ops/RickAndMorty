package com.geektech.rickandmorty.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.rickandmorty.R
import com.geektech.rickandmorty.base.BaseFragment
import com.geektech.rickandmorty.databinding.FragmentDetailEpisodeBinding

class DetailEpisodeFragment :
    BaseFragment<FragmentDetailEpisodeBinding, DetailEpisodeViewModel>(R.layout.fragment_detail_episode) {

    override val binding by viewBinding(FragmentDetailEpisodeBinding::bind)
    override val viewModel: DetailEpisodeViewModel by viewModels()
    private val args by navArgs<DetailEpisodeFragmentArgs>()

    override fun setupView() = with(binding) {
        viewModel.fetchDetailEpisode(args.id).observe(viewLifecycleOwner) {
            name.text = it.name
            airDate.text = it.airDate
            created.text = it.created
            episode.text = it.episode
        }
    }
}