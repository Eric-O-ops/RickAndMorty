package com.geektech.rickandmorty

import android.app.Application
import androidx.room.Room
import com.geektech.rickandmorty.data.db.AppDatabase
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
        var appDatabase: AppDatabase? = null
    }

    private fun getDataIntense(): AppDatabase?{
        if (appDatabase == null) {
            appDatabase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "rick_and_morty_database"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
        }
        return appDatabase
    }

    override fun onCreate() {
        super.onCreate()
        characterApi = retrofitClient.provideCharacterApiService()
        locationApi = retrofitClient.provideLocationApiService()
        episodeApi = retrofitClient.provideEpisodeApiService()
        getDataIntense()
    }
}