package com.android.movies.network

import com.android.movies.Constants
import com.android.movies.details.MovieDetails
import com.android.movies.main.BoxOffice
import com.android.movies.main.MostPopular
import com.android.movies.search.SearchMovie
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

var moshi= Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

var retrofit= Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(Constants.BASE_URL)
    .build()

interface MovieApiService{
    @GET("/API/SearchTitle/{apiKey}/{expression}")
    suspend fun searchMovie(@Path("apiKey")apiKey:String, @Path("expression")expression:String?): SearchMovie
    @GET("/en/API/BoxOffice/{apiKey}")
    suspend fun getBoxOffice(@Path("apiKey")apiKey:String): BoxOffice
    @GET("/en/API/Title/{apiKey}/{id}")
    suspend fun getDetails(@Path("apiKey")apiKey:String,@Path("id") id:String): MovieDetails
    @GET("/en/API/MostPopularMovies/{apiKey}")
    suspend fun getMostPopular(@Path("apiKey")apiKey:String): MostPopular
}

object MovieApi{
    val movieApiService :MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}

