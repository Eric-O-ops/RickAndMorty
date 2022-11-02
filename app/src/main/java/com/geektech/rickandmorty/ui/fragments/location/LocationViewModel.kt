package com.geektech.rickandmorty.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.data.repositories.LocationRepository
import com.geektech.rickandmorty.model.RickAndMortyResponse
import com.geektech.rickandmorty.model.location.LocationModel

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        return locationRepository.fetchLocation()
    }

    fun getAllFromRoom(): LiveData<List<LocationModel>>? {
        return locationRepository.getAllFromRoom()
    }
}