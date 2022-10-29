package com.geektech.rickandmorty.data.network.api

import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel
import com.geektech.rickandmorty.model.episode.EpisodeModel
import com.geektech.rickandmorty.model.location.LocationModel
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApi {

    @GET("api/character")
    fun fetchCharacter(): Call<RickAndMortyResponse<CharacterModel>>

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>
}