package com.geektech.rickandmorty.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geektech.rickandmorty.model.location.LocationModel

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<LocationModel>)

    @Query("SELECT * FROM location")
    fun getAllList(): LiveData<List<LocationModel>>
}