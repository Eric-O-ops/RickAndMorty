package com.geektech.rickandmorty.data.network

import com.geektech.rickandmorty.data.network.api.CharacterApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService():CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }
}