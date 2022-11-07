package com.geektech.rickandmorty.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.data.repositories.pagingsources.EpisodePagingSources
import com.geektech.rickandmorty.model.episode.EpisodeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    private val data: MutableLiveData<EpisodeModel> = MutableLiveData()

    fun fetchEpisode(): LiveData<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                EpisodePagingSources(App.episodeApi!!)
            }, initialKey = 1
        ).liveData
    }

    fun fetchDetailEpisode(idModel: Int): MutableLiveData<EpisodeModel> {
        App.episodeApi?.fetchDetailEpisode(idModel)?.enqueue(object : Callback<EpisodeModel> {
            override fun onResponse(call: Call<EpisodeModel>, response: Response<EpisodeModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<EpisodeModel>, t: Throwable) {}
        })
        return data
    }
}