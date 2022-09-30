package com.alecbrando.starteranime

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.alecbrando.starteranime.databinding.FragmentCharDetailBinding
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharDetail : Fragment() {
    private var _binding: FragmentCharDetailBinding? = null
    private val binding: FragmentCharDetailBinding get() = _binding!!
    private val viewModel by viewModels<CharDetailViewModel>()
    private val safeArgs: CharDetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharDetailBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        lifecycleScope.launch {
            viewModel.setAnime(safeArgs.charId)
            viewModel.anime.collectLatest { anime ->
                when (anime) {

                    is Resource.Error -> Log.d(
                        TAG,
                        "initViewsLOG - Error: ${anime.message}"
                    )
                    is Resource.Loading -> Log.d(TAG, "initViews: Loading....")
                    is Resource.Success -> {

                        println("initViews - Success ${anime.data}")
                        imageView.load(anime.data.data[2].attributes.posterImage)
                        tvTitle.text = anime.data.data[2].attributes.canonicalTitle
                        tvRating.text = anime.data.data[2].attributes.averageRating
                        tvPopularity.text = "Popularity: " + anime.data.data[2].attributes.popularity
                        description.text = anime.data.data[2].attributes.description
                    }
                    null -> Log.d(TAG, "THERES SOME NULLS HERE")
                }
            }
        }
    }

    companion object {
        const val TAG = "FragmentLogger"
    }
}
