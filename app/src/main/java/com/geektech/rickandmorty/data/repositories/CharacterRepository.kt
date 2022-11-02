package com.geektech.rickandmorty.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        App.characterApi?.fetchCharacter()
            ?.enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    response.body()?.let {
                        App.appDatabase?.characterDao()?.insertList(it.results)
                        data.value = it
                    }
                    Log.e("Character", "callBack in CharacterRepository was succeed")
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    Log.e("Character", "callBack in CharacterRepository was failed")
                }
            })
        return data
    }

    fun getCharacters(): LiveData<List<CharacterModel>>? {
        return App.appDatabase?.characterDao()?.getAllList()
    }
}