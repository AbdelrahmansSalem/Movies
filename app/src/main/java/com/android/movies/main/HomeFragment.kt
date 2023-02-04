package com.android.movies.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.android.movies.R
import com.android.movies.databinding.FragmentHomeBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }



    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.lifecycleOwner = this


        binding.mainViewModel=mainViewModel

        binding.boxOffice.adapter=BoxOfficeAdapter(BoxOfficeAdapter.onClickListener {
            GlobalScope.launch{
            mainViewModel.savaMovie(it)
            }
        })


        return binding.root
    }

}