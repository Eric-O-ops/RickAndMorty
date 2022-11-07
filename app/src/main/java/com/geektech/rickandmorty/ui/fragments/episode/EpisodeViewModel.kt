package com.geektech.rickandmorty.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.rickandmorty.data.repositories.EpisodeRepository
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.episode.EpisodeModel
import dagger.hilt.android.lifecycle.HiltViewModel

class EpisodeViewModel : ViewModel() {
    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode(): LiveData<PagingData<EpisodeModel>> {
        return episodeRepository.fetchEpisode().cachedIn(viewModelScope)
    }
}