package com.geektech.rickandmorty.ui.fragments.character.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.data.repositories.CharacterRepository
import com.geektech.rickandmorty.model.character.CharacterModel

class DetailCharacterViewModel: ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchDetailCharacter(idModel: Int): LiveData<CharacterModel> {
        return characterRepository.fetchDetailCharacter(idModel)
    }
}