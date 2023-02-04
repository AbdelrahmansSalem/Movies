package com.android.movies.favorites.localData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieDB::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDao: MovieDao
}

private lateinit var INSTANCE: MovieDatabase

fun getDatabase(context: Context): MovieDatabase {
    synchronized(MovieDatabase::class.java) {
        if(!::INSTANCE.isInitialized){
            INSTANCE=Room.databaseBuilder(
                context.applicationContext ,
                MovieDatabase::class.java, "Favorites")
                .build()
        }
    }
    return INSTANCE
}

