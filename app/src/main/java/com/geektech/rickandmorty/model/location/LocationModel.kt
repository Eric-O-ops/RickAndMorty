package com.geektech.rickandmorty.model.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geektech.rickandmorty.base.IBaseDifUtil
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationModel(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension:String,

    @SerializedName("created")
    val created: String

): IBaseDifUtil