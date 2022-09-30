package com.alecbrando.starteranime.models

data class Attributes(
    val startDate : String,
    val title : Title,
    val canonicalTitle : String,
    val posterImage : PosterImage,
    val popularity : Int,
    val averageRating : String,
    val description: String

)

