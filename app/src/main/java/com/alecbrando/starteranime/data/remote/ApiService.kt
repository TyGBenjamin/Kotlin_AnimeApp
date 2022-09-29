package com.alecbrando.starteranime.data.remote

import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getAnimes(): Anime

    companion object {
        val apiInstance = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(ApiService::class.java)
    }
}