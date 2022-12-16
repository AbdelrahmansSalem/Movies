package com.android.movies

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.main.*
import com.android.movies.search.SearchMovie
import com.squareup.picasso.Picasso

@BindingAdapter("listMostPopularData")
fun bindRecyclerView(recyclerView: RecyclerView, data: MostPopular?){
    data?.let {
        var adapter=MostPopularAdapter()
        adapter.submitList(it.items)
        recyclerView.adapter=adapter
    }

}

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, url: String?){
    url?.let {
        Picasso.get().load(it)
            .resize(880,600)
            .error(R.drawable.ic_launcher_background)
            .into(imageView)
    }

}

@BindingAdapter("listSearchData")
fun bindSearchRecyclerView(recyclerView: RecyclerView, data: SearchMovie?){
    data?.let {
        val adapter=SearchAdapter()
        adapter.submitList(it.results)
        recyclerView.adapter=adapter
    }

}


@BindingAdapter("listBoxOfficeData")
fun bindBoxOfficeRecyclerView(recyclerView: RecyclerView, data: BoxOffice?){
    data?.let {
        var adapter = BoxOfficeAdapter()
        adapter.submitList(it.items)
        recyclerView.adapter=adapter
    }

}
@BindingAdapter("setSearchImage")
fun setSearchImage(imageView: ImageView, url: String?){
    url?.let {
        Picasso.get().load(url)
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
