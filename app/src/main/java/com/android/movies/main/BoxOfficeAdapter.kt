package com.android.movies.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.databinding.BoxOfficeCardBinding

class BoxOfficeAdapter(val onclickListener:onClickListener):ListAdapter<BoxOffice.BoxOfficeWeekendDataDetail, BoxOfficeAdapter.viewHolder>(diffCallBack)  {
    class viewHolder(private val binding: BoxOfficeCardBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(boxOffice: BoxOffice.BoxOfficeWeekendDataDetail){
            binding.boxOffice=boxOffice
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(BoxOfficeCardBinding.inflate(LayoutInflater.from(parent.context)))
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var item =getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener{
            onclickListener.onClick(item)
        }
    }

    class onClickListener(val clickListener: (movie:BoxOffice.BoxOfficeWeekendDataDetail)->Unit){
        fun onClick(movie: BoxOffice.BoxOfficeWeekendDataDetail)=clickListener(movie)
    }

    object diffCallBack:DiffUtil.ItemCallback<BoxOffice.BoxOfficeWeekendDataDetail>(){
        override fun areItemsTheSame(
            oldItem: BoxOffice.BoxOfficeWeekendDataDetail, newItem: BoxOffice.BoxOfficeWeekendDataDetail
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: BoxOffice.BoxOfficeWeekendDataDetail, newItem: BoxOffice.BoxOfficeWeekendDataDetail
        ): Boolean {
            return oldItem==newItem
        }

    }
}