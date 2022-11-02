package com.geektech.rickandmorty.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geektech.rickandmorty.model.episode.EpisodeModel

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<EpisodeModel>)

    @Query("SELECT * FROM episode")
    fun getAllList(): LiveData<List<EpisodeModel>>
}