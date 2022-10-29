package com.geektech.rickandmorty.data.repositories

import android.util.Log
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
        App.characterApi?.fetchEpisode()?.enqueue(object :
            Callback<RickAndMortyResponse<EpisodeModel>> {
            override fun onResponse(
                call: Call<RickAndMortyResponse<EpisodeModel>>,
                response: Response<RickAndMortyResponse<EpisodeModel>>
            ) {
                data.value = response.body()
                Log.e("Episode", "callBack in EpisodeRepository was succeed")
            }

            override fun onFailure(call: Call<RickAndMortyResponse<EpisodeModel>>, t: Throwable) {
                Log.e("Episode", "callBack in EpisodeRepository was failed")
            }
        })
        return data
    }
}