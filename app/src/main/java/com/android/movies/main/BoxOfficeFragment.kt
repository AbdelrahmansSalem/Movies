package com.android.movies.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.android.movies.R
import com.android.movies.databinding.FragmentBoxOfficeBinding
import com.android.movies.search.MovieViewModel
import java.lang.Math.abs

class BoxOfficeFragment : Fragment() {
    lateinit var binding:FragmentBoxOfficeBinding
    private lateinit var  viewPager2: ViewPager2
    private lateinit var handler : Handler
    var imageList:ArrayList<BoxOffice.BoxOfficeWeekendDataDetail>?=null
    private lateinit var adapter: ImageAdapter

    private val viewModel: BoxOfficeViewModel by lazy {
        ViewModelProvider(this).get(BoxOfficeViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding=DataBindingUtil.inflate(inflater,R.layout.fragment_box_office,container,false)

        viewModel.boxOffice.observe(viewLifecycleOwner, Observer {
            it?.let {
                init(it.items)
                setUpTransformer()
                viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        handler.removeCallbacks(runnable)
                        handler.postDelayed(runnable , 2000)
                    }
                })
            }
        })







        return binding.root
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable , 2000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setUpTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.12f
        }

        viewPager2.setPageTransformer(transformer)
    }

    private fun init(list:ArrayList<BoxOffice.BoxOfficeWeekendDataDetail>?){
        viewPager2 = binding.viewPager2
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList=list

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
}