package com.alecbrando.starteranime.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImpl
import com.alecbrando.starteranime.domain.models.AnimeWrapper
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel() {
    private val repo = RepositoryImpl
    private val _anime: MutableStateFlow<Resource<AnimeWrapper>?> = MutableStateFlow(Resource.Loading)
    val anime = _anime.asStateFlow()

    fun setAnime(charId: String) {
        viewModelScope.launch {
            _anime.value = repo.getAnimeById(charId)
        }
    }
}