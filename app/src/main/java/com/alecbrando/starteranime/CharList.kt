package com.alecbrando.starteranime

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Layout.Directions
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.alecbrando.starteranime.adapters.CharAdapter
import com.alecbrando.starteranime.databinding.FragmentCharListBinding
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.utils.Resource
import kotlinx.coroutines.launch


class CharList : Fragment() {
    var _binding: FragmentCharListBinding? = null
    val binding: FragmentCharListBinding get() = _binding!!
    private val viewModel by viewModels<CharListViewModel>()
//    private val charAdapter: CharAdapter by lazy { CharAdapter(::navigateToDetails) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharListBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() = with(binding) {
//        rvView.adapter = charAdapter
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is Resource.Error -> viewState.message
                is Resource.Loading -> {
                    //
                    Log.d(TAG, "initViews: error")
                }
                is Resource.Success -> rvView.adapter = CharAdapter(viewState.data.data.toMutableList(),@CharListFragment ::navigateToDetails).apply{addItems(viewState.data.data)}
            }
        }
    }

    private fun navigateToDetails(charId: String) {
        val action = CharListDirections.actionCharListToCharDetail(charId)
        findNavController().navigate(action)
    }

    companion object {
        const val TAG = "DashboardFragmentLogger"
    }
}



