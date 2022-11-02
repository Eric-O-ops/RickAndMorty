package com.geektech.rickandmorty.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.location.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        App.locationApi?.fetchLocation()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    response.body()?.let {
                        App.appDatabase?.locationDao()?.insertList(it.results)
                        data.value = it
                        Log.e("Location", "callBack in LocationRepository was succeed")
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    Log.e("Location", "callBack in LocationRepository was failed")
                }
            })
        return data
    }

    fun getAllFromRoom(): LiveData<List<LocationModel>>? {
        return App.appDatabase?.locationDao()?.getAllList()

    }
}