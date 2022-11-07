package com.geektech.rickandmorty.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.rickandmorty.data.repositories.LocationRepository
import com.geektech.rickandmorty.model.location.LocationModel

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation(): LiveData<PagingData<LocationModel>> {
        return locationRepository.fetchLocation().cachedIn(viewModelScope)
    }
}