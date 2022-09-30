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


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CharList : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    var _binding : FragmentCharListBinding? = null
    val binding: FragmentCharListBinding get() =  _binding!!
    private val viewModel by viewModels<CharListViewModel>()
//    private val charAdapter: CharAdapter by lazy {CharAdapter()}





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharListBinding.inflate(inflater, container, false).also{
        _binding = it
    }.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initViews()
//    }

    private fun initViews() = with(binding) {
        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            when (viewState) {
                is Resource.Error -> viewState.message
                is Resource.Loading -> {
                    //
                }
                is Resource.Success -> rvView.adapter = CharAdapter(this@CharList::navigateToDetails).apply{
                    addItems(viewState.data.data)
                }

            }
        }
    }

     private fun navigateToDetails(animeId: String) {
        val action = CharListDirections.actionCharListToCharDetail(animeId)
        findNavController().navigate(action)
    }
    companion object {
        const val TAG = "DashboardFragmentLogger"
    }
}



