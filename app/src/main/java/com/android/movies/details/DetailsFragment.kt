package com.android.movies.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.movies.R
import com.android.movies.databinding.FragmentDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log


class DetailsFragment : Fragment() {

    lateinit var binding:FragmentDetailsBinding

    private val viewModel:DetailsViewModel by lazy {
        ViewModelProvider(this).get(DetailsViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)

        Log.i("jghjhuh",id.toString())
        viewModel.setId(id.toString())


        viewModel.id.observe(viewLifecycleOwner, Observer {
                viewModel.getData(it)
                binding.movie=viewModel.movieDetails.value
        })


        return binding.root
    }


}