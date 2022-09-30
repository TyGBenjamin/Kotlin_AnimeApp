package com.alecbrando.starteranime.data.repository
import android.util.Log
import com.alecbrando.starteranime.data.remote.ApiService
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.AnimeWrapper
import com.alecbrando.starteranime.models.Data
import com.alecbrando.starteranime.models.repository.Repository
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RepositoryImp : Repository {
    private val apiInstance by lazy { ApiService.apiInstance}
    override suspend fun getAnimes(): Resource<Data> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = apiInstance.getAnimes()
            Log.d("Repo Imp", "getAnimes: ${res.body()}")
            if(res.isSuccessful && res.body() !=null){
                Resource.Success(res.body()!!)
            }
            else{
                Resource.Error("An Error Occurred")
            }

        }        catch(e : Exception){
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun getAnimeById(id: String): Resource<AnimeWrapper> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = apiInstance.getAnimeById(id)
            if (res.isSuccessful && res.body() != null) {
                Resource.Success(res.body()!!)
            } else {
                Resource.Error("Someting Wrong")
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

}