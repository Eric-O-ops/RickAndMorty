package com.geektech.rickandmorty

import android.app.Application
import com.geektech.rickandmorty.data.network.RetrofitClient
import com.geektech.rickandmorty.data.network.api.CharacterApi

class App : Application() {

    companion object {
        private val retrofitClient = RetrofitClient()
        var characterApi: CharacterApi? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApi = retrofitClient.provideCharacterApiService()
    }
}