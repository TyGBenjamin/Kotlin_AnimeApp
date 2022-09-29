package com.alecbrando.starteranime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alecbrando.starteranime.adapters.CharAdapter
import com.alecbrando.starteranime.databinding.FragmentCharListBinding
import com.alecbrando.starteranime.models.Anime
import com.alecbrando.starteranime.utils.Resource



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CharList : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    var _binding : FragmentCharListBinding? = null
    val binding: FragmentCharListBinding get() =  _binding!!
    private val viewModel by viewModels<CharListViewModel>()
    private val charAdapter: CharAdapter by lazy {CharAdapter()}


    companion object {
        fun newInstance() = CharList()
    }



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
        rvView.adapter = charAdapter
        viewModel.anime.observe(viewLifecycleOwner){ anime ->
            when (anime){
                is Resource.Error -> {
                    // Error msg
                }
                is Resource.Loading -> {
                    // Loading Progress msg
                }
                is Resource.Success ->{
                    // Passing off our data
                    charAdapter.addItems(anime.data)
                }

            }
        }
    }
}

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(CharListViewModel::class.java)
//        // TODO: Use the ViewModel
//    }