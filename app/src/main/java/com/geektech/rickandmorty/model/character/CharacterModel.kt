package com.geektech.rickandmorty.model.character

import com.geektech.rickandmorty.base.IBaseDifUtil
import com.google.gson.annotations.SerializedName

data class CharacterModel (

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

    @SerializedName("origin")
    val origin: Origin,

    @SerializedName("location")
    val location: Location
    ): IBaseDifUtil