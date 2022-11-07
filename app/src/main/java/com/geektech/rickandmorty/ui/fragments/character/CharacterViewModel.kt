package com.geektech.rickandmorty.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.rickandmorty.data.repositories.CharacterRepository
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter(): LiveData<PagingData<CharacterModel>> {
        return characterRepository.fetchCharacter().cachedIn(viewModelScope)
    }
}