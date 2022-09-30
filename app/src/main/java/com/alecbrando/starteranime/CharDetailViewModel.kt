package com.alecbrando.starteranime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImp
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.AnimeWrapper
import com.alecbrando.starteranime.models.Data
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CharDetailViewModel: ViewModel() {
    private val repo = RepositoryImp
    private val _anime: MutableStateFlow<Resource<AnimeWrapper>?> = MutableStateFlow(Resource.Loading())
    val anime = _anime.asStateFlow()

    fun setAnime(charId: String) {
        viewModelScope.launch {
            _anime.value = repo.getAnimeById(charId)
        }
    }
}
