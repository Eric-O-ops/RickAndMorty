package com.geektech.rickandmorty.model.character

import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("name")
    val name: String,
)
