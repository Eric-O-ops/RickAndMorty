package com.geektech.rickandmorty.data.db.converter

import androidx.room.TypeConverter
import com.geektech.rickandmorty.model.character.Location
import com.geektech.rickandmorty.model.character.Origin

class Convertor {

    @TypeConverter
    fun fromLocation(model: Location): String {
        return model.name
    }

    @TypeConverter
    fun fromOrigin(model: Origin): String {
        return model.name
    }

    @TypeConverter
    fun toLocation(name: String): Location {
        return Location(name)
    }

    @TypeConverter
    fun toOrigin(name: String): Origin {
        return Origin(name)
    }
}