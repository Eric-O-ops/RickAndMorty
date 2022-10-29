package com.geektech.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Info(

    @SerializedName("point")
    val count: Int,

    @SerializedName("page")
    val page: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("prev")
    val prev: String

)
