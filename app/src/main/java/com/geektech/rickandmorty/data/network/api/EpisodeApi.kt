package com.geektech.rickandmorty.data.network.api

import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.episode.EpisodeModel
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApi {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>
}