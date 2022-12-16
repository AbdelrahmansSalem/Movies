package com.android.movies.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movies.Constants
import com.android.movies.network.MovieApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MostPopularViewModel:ViewModel() {
    private var _mostPopular= MutableLiveData<MostPopular?>()
    val mostPopular: LiveData<MostPopular?> get() = _mostPopular
    var data: MostPopular? = null

    init {
        viewModelScope.launch{
            runBlocking {
                getData()
                _mostPopular.value=data
            }

        }
    }

    suspend fun getData() {
        withContext(Dispatchers.Unconfined){
            try{
                data= MovieApi.movieApiService.getMostPopular(Constants.API_KEY)
                Log.i("Errorrrr",data?.items?.size.toString())
            }
            catch (exe:Exception){
                Log.i("Errorrrr",exe.message.toString())
            }
        }

    }
}