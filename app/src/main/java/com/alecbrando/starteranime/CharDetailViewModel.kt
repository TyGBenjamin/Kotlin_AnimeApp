package com.alecbrando.starteranime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImp
import com.alecbrando.starteranime.models.Data
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharDetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _animeDetails: MutableStateFlow<Resource<Data>?> = MutableStateFlow(null)
    val animeDetails = _animeDetails.asStateFlow()

    private val repo = RepositoryImp

    private fun getAnimeById(id: String) {
        viewModelScope.launch {
            _animeDetails.value = repo.getAnimeById(id)
        }
    }

}