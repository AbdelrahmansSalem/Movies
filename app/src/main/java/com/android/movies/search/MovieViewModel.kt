package com.android.movies.search

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

class MovieViewModel:ViewModel() {
    private var _searchData= MutableLiveData<SearchMovie?>()
    val searchData: LiveData<SearchMovie?> get() = _searchData
    var data: SearchMovie? = null


    private var _navigate_to_details=MutableLiveData<String?>()
    val navigate_to_details:LiveData<String?>get() = _navigate_to_details

    var name =MutableLiveData<String>()
    init {
        name.value=""
    }

    fun navigateToDetails(id: String){
        _navigate_to_details.value=id
    }
    fun navigateToDetailsDone()
    {
        _navigate_to_details.value=null
    }


    fun getData(){
        viewModelScope.launch{
            if (name.value?.isEmpty() == true){
                runBlocking {
                    getMovie("mulan")
                    _searchData.value=data
                }

            }
            else{
                runBlocking {
                    getMovie(name.value)
                    _searchData.value=data
                }

            }
        }

    }

    suspend fun getMovie(searchName:String?) {
        withContext(Dispatchers.Unconfined){
            try{
                data= MovieApi.movieApiService.searchMovie(Constants.API_KEY1,searchName)
            }
            catch (exe:Exception){
                Log.i("Errorrrr",exe.message.toString())
            }
        }

    }
}