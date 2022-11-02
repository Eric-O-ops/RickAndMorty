package com.geektech.rickandmorty.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.data.repositories.CharacterRepository
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        return characterRepository.fetchCharacter()
    }

    fun getAllFromRoom(): LiveData<List<CharacterModel>>? {
        return characterRepository.getCharacters()
    }
}