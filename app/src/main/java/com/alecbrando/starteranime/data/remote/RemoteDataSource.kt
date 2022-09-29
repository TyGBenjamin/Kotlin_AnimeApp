package com.alecbrando.starteranime.data.remote

import com.alecbrando.starteranime.domain.models.Anime
import com.alecbrando.starteranime.domain.models.AnimeListResponseWrapper
import com.alecbrando.starteranime.domain.models.AnimeObj
import com.alecbrando.starteranime.util.Constants.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteDataSource {
    @GET("trending/anime")
    suspend fun getAnimeList(): Response<AnimeListResponseWrapper>

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: String): Response<AnimeObj>

    companion object {
        val apiInstance = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(RemoteDataSource::class.java)
    }
}