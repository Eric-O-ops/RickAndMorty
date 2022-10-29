package com.geektech.rickandmorty.model.episode

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val airDate: String,

    @SerializedName("episode")
    val episode: String,

    @SerializedName("created")
    val created: String

)
