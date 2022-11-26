package com.android.movies.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.android.movies.R
import com.squareup.picasso.Picasso

class ImageAdapter(private val imageList: ArrayList<BoxOffice.BoxOfficeWeekendDataDetail>?, private val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.image_slider, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Picasso.get().load(imageList?.get(position)?.image).into(  holder.imageView)
        if (position == imageList?.size?.minus(1) ){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return imageList!!.size
    }

    private val runnable = Runnable {
        imageList?.addAll(imageList)
        notifyDataSetChanged()
    }
}