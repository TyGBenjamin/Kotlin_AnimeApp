package com.alecbrando.starteranime

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CharDetail : Fragment() {

    companion object {
        fun newInstance() = CharDetail()
    }

//    private lateinit var viewModel: CharDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_char_detail, container, false)
    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(CharDetailViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}