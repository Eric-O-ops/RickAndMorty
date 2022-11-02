package com.geektech.rickandmorty.data.network.api

import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.location.LocationModel
import retrofit2.Call
import retrofit2.http.GET

interface LocationApi {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationModel>>
}