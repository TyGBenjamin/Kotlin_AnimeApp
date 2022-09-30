package com.alecbrando.starteranime.data.remote

import com.alecbrando.starteranime.domain.models.AnimeListWraper
import com.alecbrando.starteranime.util.Constants
import com.alecbrando.starteranime.util.Constants.BASE_URL
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("/edge/anime/")
    suspend fun getAnimes(): Response<AnimeListWraper>

    companion object{
        val apiIntance = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()
        ).build().create(ApiService::class.java)
    }
}