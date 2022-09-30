package com.alecbrando.starteranime.models.repository

import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.AnimeWrapper
import com.alecbrando.starteranime.models.Data
import com.alecbrando.starteranime.utils.Resource

interface Repository {
    suspend fun getAnimes() : Resource<Data>
    suspend fun getAnimeById(id: String): Resource<AnimeWrapper>
}