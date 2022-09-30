package com.alecbrando.starteranime.presentation.ListFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImpl
import com.alecbrando.starteranime.domain.models.AnimeListWraper
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private val _viewState: MutableLiveData<Resource<AnimeListWraper>> = MutableLiveData()
    val viewState: LiveData<Resource<AnimeListWraper>>  = _viewState

    private val repo = RepositoryImpl

    init {
        getAnimes()
    }

    private fun getAnimes() = viewModelScope.launch(Dispatchers.Main){
        //repo.apiInstance
        _viewState.value = repo.getAnimes()
    }
}