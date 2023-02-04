package com.android.movies.favorites

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.movies.favorites.localData.MovieDB
import com.android.movies.favorites.localData.getDatabase
import kotlinx.coroutines.*

class FavoriteViewModel(application: Application):AndroidViewModel(application) {
    private var dataBase= getDatabase(application)
    private var _movies=MutableLiveData<List<MovieDB>?>()
    val movies:LiveData<List<MovieDB>?> get() = _movies
    var data :List<MovieDB>?=null
    init {
        viewModelScope.launch{
            runBlocking {
                getallData()
                _movies.value=data
            }

        }
    }

    suspend fun getallData(){
        withContext(Dispatchers.Default){
            try{
                data=dataBase.movieDao.getAllData()
                Log.i("dataaaaa", movies.value?.get(0)?.title.toString())
            }
            catch (e:Exception){
                Log.i("Exception",e.toString())
            }

        }
    }
}