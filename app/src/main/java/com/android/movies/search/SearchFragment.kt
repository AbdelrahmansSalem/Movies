package com.android.movies.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.movies.R

import com.android.movies.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    lateinit var binding:FragmentSearchBinding
    private val searchViewModel:SearchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)
        binding.lifecycleOwner = this


        binding.movie=searchViewModel
        binding.search.setOnClickListener {
            searchViewModel.getData()
        }


        return binding.root
    }

}