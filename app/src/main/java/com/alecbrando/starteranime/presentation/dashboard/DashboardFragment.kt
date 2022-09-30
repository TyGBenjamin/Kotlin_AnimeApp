package com.alecbrando.starteranime

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alecbrando.starteranime.databinding.FragmentDashboardBinding
import com.alecbrando.starteranime.presentation.dashboard.DashboardAdapter
import com.alecbrando.starteranime.presentation.dashboard.DashboardViewModel
import com.alecbrando.starteranime.util.Resource
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding: FragmentDashboardBinding get() = _binding!!
    private val viewModel by viewModels<DashboardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentDashboardBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
        lifecycleScope.launch {
            viewModel.animeList.collectLatest { animeList ->
                when (animeList) {
                    is Resource.Error -> Log.d(TAG, "initViews - Error: ${animeList.message}")
                    is Resource.Loading -> Log.d(TAG, "initViews: Loading....")
                    is Resource.Success -> rvList.adapter = DashboardAdapter(
                        animeList.data.data.toMutableList(),
                        @DashboardFragment ::navigateToDetails
                    ).apply {
                        addItems(animeList.data.data)
                    }
                }
            }
        }
    }

    private fun navigateToDetails(animeId: String) {
        val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(animeId)
        findNavController().navigate(action)
    }

    companion object {
        const val TAG = "DashboardFragmentLogger"
    }
}