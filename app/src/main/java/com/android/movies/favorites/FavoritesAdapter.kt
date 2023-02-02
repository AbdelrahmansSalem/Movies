package com.android.movies.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.databinding.FavoriteCardBinding
import com.android.movies.favorites.localData.MovieDB

class FavoritesAdapter():ListAdapter<MovieDB,FavoritesAdapter.viewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(FavoriteCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var item=getItem(position)
        holder.bind(item)
    }


    class viewHolder(var binding:FavoriteCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movieDB: MovieDB){
            binding.movie=movieDB
            binding.executePendingBindings()
        }
    }

    object diffCallBack:DiffUtil.ItemCallback<MovieDB>() {
        override fun areItemsTheSame(oldItem: MovieDB, newItem: MovieDB): Boolean {
            return oldItem.movieId==newItem.movieId
        }

        override fun areContentsTheSame(oldItem: MovieDB, newItem: MovieDB): Boolean {
            return oldItem==newItem
        }
    }
}