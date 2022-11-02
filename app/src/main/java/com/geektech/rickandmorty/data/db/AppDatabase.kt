package com.geektech.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.geektech.rickandmorty.data.db.converter.Convertor
import com.geektech.rickandmorty.data.db.daos.CharacterDao
import com.geektech.rickandmorty.data.db.daos.EpisodeDao
import com.geektech.rickandmorty.data.db.daos.LocationDao
import com.geektech.rickandmorty.model.character.CharacterModel
import com.geektech.rickandmorty.model.episode.EpisodeModel
import com.geektech.rickandmorty.model.location.LocationModel

@Database(
    entities = [CharacterModel::class, LocationModel::class, EpisodeModel::class],
    version = 4
)
@TypeConverters(Convertor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    abstract fun locationDao(): LocationDao

    abstract fun episodeDao(): EpisodeDao
}