package com.geektech.rickandmorty.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geektech.rickandmorty.model.character.CharacterModel

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<CharacterModel>)

    @Query("SELECT * FROM character")
    fun getAllList(): LiveData<List<CharacterModel>>

}