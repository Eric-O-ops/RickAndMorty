package com.geektech.rickandmorty.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        App.characterApi?.fetchCharacter()
            ?.enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    data.value = response.body()
                    Log.e("Character", "callBack in CharacterVM was succeed")
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    Log.e("Character", "callBack in CharacterVM was failed")
                }
            })
        return data
    }
}