package com.android.movies.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.movies.R
import com.android.movies.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding= DataBindingUtil.inflate<FragmentFavoritesBinding>(inflater,R.layout.fragment_favorites,container,false)

        return binding.root
    }


}