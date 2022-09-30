package com.alecbrando.starteranime.data.remote


import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.Data
import com.alecbrando.starteranime.utils.Constants.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("trending/anime")
    suspend fun getAnimes(): Response<Data>

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: String): Response<Anime>

    companion object {
        val apiInstance =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
    }
}


//@GET("/trending/anime")
//suspend fun getAnimes(): Response<MutableList<Anime>>
//
//companion object {
//    val apiInstance = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
//        GsonConverterFactory.create()
//    ).build().create(ApiService::class.java)
//}