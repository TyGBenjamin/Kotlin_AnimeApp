package com.alecbrando.starteranime.data.repository

import com.alecbrando.starteranime.data.remote.ApiService
import com.alecbrando.starteranime.domain.Repository
import com.alecbrando.starteranime.domain.models.AnimeListWraper
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryImpl:Repository {

    val apiInstance by lazy{
        ApiService.apiIntance
    }
    override suspend fun getAnimes(): Resource<AnimeListWraper> = withContext(Dispatchers.IO) {
       return@withContext try {
           val res = apiInstance.getAnimes()
           if(res.isSuccessful && res.body() != null){
               Resource.Success(res.body()!!)
           } else {
               Resource.Error("Something went wrong")
           }
       } catch (e: Exception) {
           Resource.Error(e.message.toString())
       }
    }
}