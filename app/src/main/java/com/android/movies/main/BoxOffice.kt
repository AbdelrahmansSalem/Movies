package com.android.movies.main

data class BoxOffice (
    var items: ArrayList<BoxOfficeWeekendDataDetail>,
    var errorMessage:String
) {
    data class BoxOfficeWeekendDataDetail (
        var id: String,
        var rank : String,
        var title : String,
        var image : String,
        var weekend : String,
        var gross  : String,
        var weeks  : String
    )
}

