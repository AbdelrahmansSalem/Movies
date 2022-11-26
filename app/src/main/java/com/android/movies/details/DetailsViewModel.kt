package com.android.movies.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movies.Constants
import com.android.movies.network.MovieApi
import com.android.movies.search.SearchMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class DetailsViewModel:ViewModel() {


    private var _id =MutableLiveData<String>()
    val id:LiveData<String> get() = _id

    private var _movieDetails =MutableLiveData<MovieDetails?>()
    val movieDetails:LiveData<MovieDetails?> get() = _movieDetails

    var data: MovieDetails? = null


    fun setId(id: String) {
        _id.value=id
    }

    fun getData(id:String){
        viewModelScope.launch{
            runBlocking {
                getDataDetails(id)
                _movieDetails.value=data
            }
        }
    }
    suspend fun getDataDetails(id: String) {
        withContext(Dispatchers.Unconfined){
            try{
                data= MovieApi.movieApiService.getDetails(Constants.API_KEY1,id)
                data?.title?.let { Log.i("Errorrrr", it) }
            }
            catch (exe:Exception){
                Log.i("Errorrrr",exe.message.toString())
            }
        }
    }

}