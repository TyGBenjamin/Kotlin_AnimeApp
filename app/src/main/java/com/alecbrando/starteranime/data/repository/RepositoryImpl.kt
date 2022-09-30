package com.alecbrando.starteranime.data.repository

import com.alecbrando.starteranime.data.remote.RemoteDataSource
import com.alecbrando.starteranime.domain.models.AnimeListResponseWrapper
import com.alecbrando.starteranime.domain.models.AnimeWrapper
import com.alecbrando.starteranime.domain.repository.Repository
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryImpl : Repository {

    private val apiInstance by lazy { RemoteDataSource.apiInstance }

    override suspend fun getAnimeList(): Resource<AnimeListResponseWrapper> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = apiInstance.getAnimeList()
            if (res.isSuccessful && res.body() != null) {
                Resource.Success(res.body()!!)
            } else {
                Resource.Error("Someting Wong")
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun getAnimeById(id: String): Resource<AnimeWrapper> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = apiInstance.getAnimeById(id)
            if (res.isSuccessful && res.body() != null) {
                Resource.Success(res.body()!!)
            } else {
                Resource.Error("Someting Wong")
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
}