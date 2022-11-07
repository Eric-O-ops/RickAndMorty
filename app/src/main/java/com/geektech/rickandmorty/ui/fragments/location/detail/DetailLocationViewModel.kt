package com.geektech.rickandmorty.ui.fragments.location.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.rickandmorty.data.repositories.LocationRepository
import com.geektech.rickandmorty.model.location.LocationModel

class DetailLocationViewModel: ViewModel() {

    private val repository = LocationRepository()

    fun fetchDetailLocation(idModel: Int): LiveData<LocationModel> {
        return repository.fetchDetailLocation(idModel)
    }
}