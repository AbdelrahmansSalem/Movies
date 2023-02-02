package com.android.movies.main

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.android.movies.Constants
import com.android.movies.favorites.localData.MovieDatabase
import com.android.movies.favorites.localData.getDatabase
import com.android.movies.favorites.localData.getDatabaseModel
import com.android.movies.network.MovieApi
import com.android.movies.search.SearchMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainViewModel(application: Application):AndroidViewModel(application) {

    private var movieDatabase= getDatabase(application)
    private var _boxOffice= MutableLiveData<BoxOffice?>()
    val boxOffice: LiveData<BoxOffice?> get() = _boxOffice
    var data: BoxOffice? = null

    private var _mostPopular= MutableLiveData<MostPopular?>()
    val mostPopular: LiveData<MostPopular?> get() = _mostPopular
    var dataPopular: MostPopular? = null


    init {
        viewModelScope.launch{
            runBlocking {
                getData()
                _boxOffice.value=data
                getDataPopular()
                _mostPopular.value=dataPopular
            }

        }
    }

    suspend fun getData() {
        withContext(Dispatchers.Default){
            try{
                data= MovieApi.movieApiService.getBoxOffice(Constants.API_KEY)
                Log.i("Errorrrr",data?.items?.size.toString())
            }
            catch (exe:Exception){
                Log.i("Errorrrr",exe.message.toString())
            }
        }

    }

    suspend fun getDataPopular() {
        withContext(Dispatchers.Default){
            try{
                dataPopular= MovieApi.movieApiService.getMostPopular(Constants.API_KEY)
                Log.i("Errorrrr",dataPopular?.items?.size.toString())
            }
            catch (exe:Exception){
                Log.i("Errorrrr",exe.message.toString())
            }
        }

    }

    suspend fun savaMovie(movie: BoxOffice.BoxOfficeWeekendDataDetail,context: Context){
        withContext(Dispatchers.Default){
            movieDatabase.movieDao.insertMovie(getDatabaseModel(movie,context))
        }

    }

}