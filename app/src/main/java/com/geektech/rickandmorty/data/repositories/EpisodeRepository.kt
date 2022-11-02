package com.geektech.rickandmorty.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.episode.EpisodeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        App.episodeApi?.fetchEpisode()?.enqueue(object :
            Callback<RickAndMortyResponse<EpisodeModel>> {
            override fun onResponse(
                call: Call<RickAndMortyResponse<EpisodeModel>>,
                response: Response<RickAndMortyResponse<EpisodeModel>>
            ) {
                response.body()?.let {
                    App.appDatabase?.episodeDao()?.insertList(it.results)
                    data.value = it
                    Log.e("Episode", "callBack in EpisodeRepository was succeed")
                }
            }

            override fun onFailure(call: Call<RickAndMortyResponse<EpisodeModel>>, t: Throwable) {
                Log.e("Episode", "callBack in EpisodeRepository was failed")
            }
        })
        return data
    }

    fun getAllFromRoom(): LiveData<List<EpisodeModel>>? {
        return App.appDatabase?.episodeDao()?.getAllList()
    }
}