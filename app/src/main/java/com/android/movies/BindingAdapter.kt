package com.android.movies

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.search.MoviesAdapter
import com.android.movies.search.SearchMovie
import com.squareup.picasso.Picasso

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: SearchMovie?){
    data?.let {
       var adapter =recyclerView.adapter as MoviesAdapter
        adapter.submitList(it.results)

    }

}
@BindingAdapter("setImage")
fun setImage(imageView: ImageView, url: SearchMovie.SearchList?){
    url?.let {
        Picasso.get().load(it.image)
            .resize(500,500)
            .error(R.drawable.ic_launcher_background)

            .into(imageView)
    }

}
@BindingAdapter("setImageDetails")
fun setImageDetails(imageView: ImageView, url: String?){
    url?.let {
        Picasso.get().load(it)
            .resize(500,500)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }

}
