package com.android.movies.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.databinding.SearchCardBinding
import com.android.movies.search.SearchMovie

class SearchAdapter(): ListAdapter<SearchMovie.SearchList, SearchAdapter.MovieViewHolder>(
    diffCallBack
) {


    class MovieViewHolder(private var binding:SearchCardBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: SearchMovie.SearchList){
            binding.movie=movie
            binding.executePendingBindings()
        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var item =getItem(position)
        holder.bind(item)
//        holder.itemView.setOnClickListener{
//            onclickListener.onClick(item)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(SearchCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    class onClickListener(val clickListener: (movie: SearchMovie.SearchList)->Unit){
        fun onClick(movie: SearchMovie.SearchList)=clickListener(movie)
    }
}

object diffCallBack: DiffUtil.ItemCallback<SearchMovie.SearchList>(){
    override fun areItemsTheSame(oldItem: SearchMovie.SearchList, newItem: SearchMovie.SearchList): Boolean {
        return oldItem ==newItem
    }

    override fun areContentsTheSame(oldItem: SearchMovie.SearchList, newItem: SearchMovie.SearchList): Boolean {
        return oldItem.id==newItem.id
    }

}