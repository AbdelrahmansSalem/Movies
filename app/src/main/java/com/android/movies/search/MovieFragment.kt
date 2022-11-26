package com.android.movies.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.movies.R
import com.android.movies.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {
    lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by lazy {
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_movie,container,false)
        binding.lifecycleOwner = this

        binding.movieViewModel=viewModel

        binding.movies.adapter=MoviesAdapter(MoviesAdapter.onClickListener{
            viewModel.navigateToDetails(it.id)
        })


        viewModel.navigate_to_details.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(MovieFragmentDirections.actionMovieFragmentToDetailsFragment(it))
                viewModel.navigateToDetailsDone()
            }
        })

        viewModel.name.observe(viewLifecycleOwner, Observer {
                viewModel.getData()


        })

        return binding.root
    }

}