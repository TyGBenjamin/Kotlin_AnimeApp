package com.alecbrando.starteranime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImp
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.models.Data
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.launch


class CharListViewModel : ViewModel() {
    private val _viewState : MutableLiveData<Resource<Data>> = MutableLiveData()
    val viewState : LiveData<Resource<Data>> = _viewState
    private val repo = RepositoryImp

    init{
        getAnimes()
    }

    private fun getAnimes() = viewModelScope.launch {
        _viewState.value = repo.getAnimes()
    }
}
