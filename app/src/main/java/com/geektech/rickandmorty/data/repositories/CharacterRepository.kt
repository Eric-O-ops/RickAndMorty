package com.geektech.rickandmorty.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.data.repositories.pagingsources.CharacterPagingSources
import com.geektech.rickandmorty.model.character.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    val data: MutableLiveData<CharacterModel> = MutableLiveData()

    fun fetchCharacter(): LiveData<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSources(App.characterApi!!)
            }, initialKey = 1
        ).liveData
    }

    fun fetchDetailCharacter(idModel: Int): MutableLiveData<CharacterModel> {
        App.characterApi?.fetchDetailCharacter(idModel)?.enqueue(
            object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<CharacterModel>, t: Throwable) {}
            }
        )
        return data
    }
}