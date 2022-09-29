package com.alecbrando.starteranime.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImpl
import com.alecbrando.starteranime.domain.models.AnimeListResponseWrapper
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val _animeList: MutableStateFlow<Resource<AnimeListResponseWrapper>> =
        MutableStateFlow(Resource.Loading)
    val animeList = _animeList.asStateFlow()

    val repo = RepositoryImpl

    init {
        getAnimes()
    }

    private fun getAnimes() {
        viewModelScope.launch {
            _animeList.value = repo.getAnimeList()
        }
    }
}