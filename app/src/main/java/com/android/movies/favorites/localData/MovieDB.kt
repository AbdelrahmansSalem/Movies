package com.android.movies.favorites.localData

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.lifecycle.Transformations.map
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.android.movies.main.BoxOffice

@Entity(tableName = "Movies")
data class MovieDB (
    @PrimaryKey val movieId:String,
      val title:String?,
     val image:String?,
)

suspend fun getDatabaseModel(movie: BoxOffice.BoxOfficeWeekendDataDetail,context: Context):MovieDB{
//    var imageLoader= ImageLoader(context)
//    val request = ImageRequest.Builder(context)
//        .data(movie.image)
//        .build()
//    val result:Drawable = (imageLoader.execute(request) as SuccessResult).drawable
//    var bitmap=(result as BitmapDrawable).bitmap
    return MovieDB(movie.id,movie.title,movie.image)
}

