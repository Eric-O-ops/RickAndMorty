package com.geektech.rickandmorty

import android.app.Application
import com.geektech.rickandmorty.data.network.RetrofitClient
import com.geektech.rickandmorty.data.network.api.CharacterApi
import com.geektech.rickandmorty.data.network.api.EpisodeApi
import com.geektech.rickandmorty.data.network.api.LocationApi

class App : Application() {

    companion object {
        private val retrofitClient = RetrofitClient()
        var characterApi: CharacterApi? = null
        var locationApi: LocationApi? = null
        var episodeApi: EpisodeApi? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApi = retrofitClient.provideCharacterApiService()
        locationApi = retrofitClient.provideLocationApiService()
        episodeApi = retrofitClient.provideEpisodeApiService()
    }
}