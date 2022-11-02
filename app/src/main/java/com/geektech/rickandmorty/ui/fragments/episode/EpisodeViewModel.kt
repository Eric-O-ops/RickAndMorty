package com.geektech.rickandmorty.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.data.repositories.EpisodeRepository
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.episode.EpisodeModel

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        return episodeRepository.fetchEpisode()
    }

    fun getAllFromRoom(): LiveData<List<EpisodeModel>>? {
        return episodeRepository.getAllFromRoom()
    }
}