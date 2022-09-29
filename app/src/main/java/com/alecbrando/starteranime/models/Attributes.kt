package com.alecbrando.starteranime.models

data class Attributes(
    val startDate : String,
    val title : List<Title>,
    val canonicalTitle : String,
    val posterImage : List<PosterImage>,
    val popularity : Int,
    val averageRating : String

)
