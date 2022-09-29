package com.alecbrando.starteranime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.starteranime.data.repository.RepositoryImp
import com.alecbrando.starteranime.data.repository.RepositoryImp.getAnimes
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharListViewModel : ViewModel() {

    private val _anime : MutableLiveData<Resource<List<Anime>>> = MutableLiveData()
    val anime : LiveData<Resource<List<Anime>>> = _anime
    private val repo = RepositoryImp
    init {
        getAnimes()
    }
    private fun getAnimes() = viewModelScope.launch(Dispatchers.Main){
        _anime.value = repo.getAnimes()
    }
}