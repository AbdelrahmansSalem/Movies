package com.android.movies.main

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

class BoxOfficeViewModel:ViewModel() {

    private var _boxOffice= MutableLiveData<BoxOffice?>()
    val boxOffice: LiveData<BoxOffice?> get() = _boxOffice
    var data: BoxOffice? = null

    init {
        viewModelScope.launch{
            runBlocking {
                getData()
                _boxOffice.value=data
            }

        }
    }

    suspend fun getData() {
        withContext(Dispatchers.Unconfined){
            try{
                data= MovieApi.movieApiService.boxOffice(Constants.API_KEY1)
                Log.i("Errorrrr",data?.items?.size.toString())
            }
            catch (exe:Exception){
                Log.i("Errorrrr",exe.message.toString())
            }
        }

    }

}