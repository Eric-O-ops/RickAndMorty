package com.geektech.rickandmorty.data.network

import com.geektech.rickandmorty.data.network.api.CharacterApi
import com.geektech.rickandmorty.data.network.api.EpisodeApi
import com.geektech.rickandmorty.data.network.api.LocationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(provideInspector())
            .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()

    private fun provideInspector(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideCharacterApiService(): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }

    fun provideLocationApiService(): LocationApi {
        return retrofit.create(LocationApi::class.java)
    }

    fun provideEpisodeApiService(): EpisodeApi {
        return retrofit.create(EpisodeApi::class.java)
    }
}