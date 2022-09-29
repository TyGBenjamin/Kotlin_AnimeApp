package com.alecbrando.starteranime

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alecbrando.starteranime.databinding.FragmentCharListBinding

class CharList : Fragment() {
    var _binding : FragmentCharListBinding? = null
    val binding: FragmentCharListBinding get() =  _binding!!


    companion object {
        fun newInstance() = CharList()
    }

    private lateinit var viewModel: CharListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharListBinding.inflate(inflater, container, false).also{
        _binding = it
    }.root

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CharListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}