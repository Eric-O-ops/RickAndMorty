package com.geektech.rickandmorty.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geektech.rickandmorty.App
import com.geektech.rickandmorty.data.repositories.pagingsources.LocationPagingSources
import com.geektech.rickandmorty.model.location.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    private val data: MutableLiveData<LocationModel> = MutableLiveData()

    fun fetchLocation(): LiveData<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApi!!)
            }, initialKey = 1
        ).liveData
    }

    fun fetchDetailLocation(idModel: Int): MutableLiveData<LocationModel> {

        App.locationApi?.fetchDetailLocation(idModel)?.enqueue(object : Callback<LocationModel> {
            override fun onResponse(call: Call<LocationModel>, response: Response<LocationModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<LocationModel>, t: Throwable) {}
        })
        return data
    }
}