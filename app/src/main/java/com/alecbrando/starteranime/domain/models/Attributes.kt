package com.alecbrando.starteranime.domain.models

import com.google.gson.annotations.SerializedName

data class Attributes(
    val synopsis: String?,
    val posterImage: Images,
    @SerializedName(value = "canonicalTitle")
    val title : String,
    @SerializedName(value = "averageRating")
    val score : String,
    @SerializedName(value = "ratingRank")
    val rank : String,
    @SerializedName(value = "popularityRating")
    val popularity : String,
)
