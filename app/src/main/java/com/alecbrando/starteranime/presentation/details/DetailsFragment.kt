package com.alecbrando.starteranime

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
import com.alecbrando.starteranime.databinding.FragmentDashboardBinding
import com.alecbrando.starteranime.databinding.FragmentDetailsBinding
import com.alecbrando.starteranime.presentation.dashboard.DashboardAdapter
import com.alecbrando.starteranime.presentation.details.DetailsViewModel
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!
    private val viewModel by viewModels<DetailsViewModel>()
    private val safeArgs: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDetailsBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        lifecycleScope.launch {
            viewModel.setAnime(safeArgs.animeId)
            viewModel.anime.collectLatest { anime ->
                when (anime) {
                    is Resource.Error -> Log.d(
                        TAG,
                        "initViews - Error: ${anime.message}"
                    )
                    is Resource.Loading -> Log.d(TAG, "initViews: Loading....")
                    is Resource.Success -> {
//                        println("initViews - Success ${anime.data.data.attributes.synopsis}")
                        println("initViews - Success ${anime.data}")
                        ivPoster.load(anime.data.data.attributes.posterImage.large)
                        tvTitle.text = anime.data.data.attributes.title
                        tvScore.text = "Score: " + anime.data.data.attributes.score
                        tvRank.text = "Rank: " + anime.data.data.attributes.rank
                        tvPopularity.text = "Popularity: " + anime.data.data.attributes.popularity
                        description.text = "Sypnosis: " + anime.data.data.attributes.synopsis
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