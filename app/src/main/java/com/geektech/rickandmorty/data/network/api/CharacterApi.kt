package com.geektech.rickandmorty.data.network.api

import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.character.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character")
    suspend fun fetchCharacter(
        @Query("page") page: Int
    ): RickAndMortyResponse<CharacterModel>

    @GET("api/character/{id}")
     fun fetchDetailCharacter(
        @Path("id") idModel: Int?
    ): Call<CharacterModel>
}