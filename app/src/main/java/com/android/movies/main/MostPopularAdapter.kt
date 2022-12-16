package com.android.movies.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.databinding.MostPopularCardBinding

class MostPopularAdapter(): ListAdapter<MostPopular.MostPopularDataDetail, MostPopularAdapter.viewHolder>(diffCallBack) {

    class viewHolder(private var binding: MostPopularCardBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(mostPopular: MostPopular.MostPopularDataDetail){
            binding.mostPopular=mostPopular
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(MostPopularCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       var item =getItem(position)
        holder.bind(item)
    }

    object diffCallBack:DiffUtil.ItemCallback<MostPopular.MostPopularDataDetail>() {
        override fun areItemsTheSame(
            oldItem: MostPopular.MostPopularDataDetail, newItem: MostPopular.MostPopularDataDetail
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: MostPopular.MostPopularDataDetail, newItem: MostPopular.MostPopularDataDetail
        ): Boolean {
            return oldItem.id==newItem.id
        }
    }


}

