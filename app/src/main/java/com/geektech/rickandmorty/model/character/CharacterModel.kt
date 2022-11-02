package com.geektech.rickandmorty.model.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.geektech.rickandmorty.base.IBaseDifUtil
import com.geektech.rickandmorty.data.db.converter.Convertor
import com.google.gson.annotations.SerializedName
import java.util.Objects

@Entity(tableName = "character")
data class CharacterModel (

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val  id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("species")
    val species: String,

    @TypeConverters(Convertor::class)
    @SerializedName("origin")
    val origin: Origin,

    @TypeConverters(Convertor::class)
    @SerializedName("location")
    val location: Location
    ): IBaseDifUtil