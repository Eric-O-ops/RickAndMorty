package com.geektech.rickandmorty.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.location.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {

    val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        App.characterApi?.fetchLocation()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    data.value = response.body()
                    Log.e("Location", "callBack in LocationVM was succeed")
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    Log.e("Location", "callBack in LocationVM was failed")
                }
            })
        return data
    }
}