package com.geektech.rickandmorty.ui.fragments.episode.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.data.repositories.EpisodeRepository
import com.geektech.rickandmorty.model.episode.EpisodeModel

class DetailEpisodeViewModel: ViewModel() {

    private val repository = EpisodeRepository()

    fun fetchDetailEpisode(idModel: Int): LiveData<EpisodeModel> {
        return repository.fetchDetailEpisode(idModel)
    }
}