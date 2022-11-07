package com.geektech.rickandmorty.model.episode

import com.geektech.rickandmorty.base.IBaseDifUtil
import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    override val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val airDate: String,

    @SerializedName("episode")
    val episode: String,

    @SerializedName("created")
    val created: String

): IBaseDifUtil
