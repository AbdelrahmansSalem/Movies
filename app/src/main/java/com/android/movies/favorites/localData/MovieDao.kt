package com.android.movies.favorites.localData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("select * from favorite_movies")
    fun getAllData():List<MovieDB>?


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movieDB: MovieDB)


}