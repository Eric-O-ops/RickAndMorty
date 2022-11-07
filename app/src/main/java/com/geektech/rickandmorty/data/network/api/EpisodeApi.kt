package com.geektech.rickandmorty.data.network.api

import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel
import com.geektech.rickandmorty.model.episode.EpisodeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApi {

    @GET("api/episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int
    ): RickAndMortyResponse<EpisodeModel>

    @GET("api/episode/{id}")
    fun fetchDetailEpisode(
        @Path("id") idModel: Int?
    ): Call<EpisodeModel>
}