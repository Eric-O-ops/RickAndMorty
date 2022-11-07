package com.geektech.rickandmorty.data.network.api

import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.location.LocationModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LocationApi {

    @GET("api/location")
    suspend fun fetchLocation(
        @Query("page") page: Int
    ): RickAndMortyResponse<LocationModel>

    @GET("api/location/{id}")
    fun fetchDetailLocation(
        @Path("id") idModel: Int?
    ): Call<LocationModel>
}