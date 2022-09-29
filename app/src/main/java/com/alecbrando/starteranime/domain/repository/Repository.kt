package com.alecbrando.starteranime.domain.repository

import com.alecbrando.starteranime.domain.models.Anime
import com.alecbrando.starteranime.domain.models.AnimeListResponseWrapper
import com.alecbrando.starteranime.domain.models.AnimeObj
import com.alecbrando.starteranime.util.Resource

interface Repository {
    suspend fun getAnimeList(): Resource<AnimeListResponseWrapper>
    suspend fun getAnimeById(id: String): Resource<AnimeObj>
}