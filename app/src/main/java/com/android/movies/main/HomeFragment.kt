package com.android.movies.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.movies.R
import com.android.movies.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    private val boxOfficeViewModel: BoxOfficeViewModel by lazy {
        ViewModelProvider(this).get(BoxOfficeViewModel::class.java)
    }

    private val mostPopularViewModel: MostPopularViewModel by lazy {
        ViewModelProvider(this).get(MostPopularViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.lifecycleOwner = this


        binding.boxOfficeViewModel=boxOfficeViewModel
        binding.mostPopularViewModel=mostPopularViewModel



        return binding.root
    }

}