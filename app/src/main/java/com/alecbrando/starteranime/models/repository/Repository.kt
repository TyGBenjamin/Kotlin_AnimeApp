package com.alecbrando.starteranime.models.repository

import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.utils.Resource

interface Repository {
    suspend fun getAnimes() : Resource<List<Anime>>
}