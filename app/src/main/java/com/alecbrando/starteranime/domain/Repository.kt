package com.alecbrando.starteranime.domain

import com.alecbrando.starteranime.domain.models.AnimeListWraper
import com.alecbrando.starteranime.util.Resource

interface Repository {
    suspend fun getAnimes(): Resource<AnimeListWraper>
}