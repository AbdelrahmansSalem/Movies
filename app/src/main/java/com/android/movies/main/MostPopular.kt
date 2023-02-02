package com.android.movies.main

data class MostPopular(
    var items: List<MostPopularDataDetail>,
    var errorMessage: String
) {
    data class MostPopularDataDetail(
        var id: String,
        var rank: String,
        var rankUpDown: String,
        var title: String,
        var fullTitle: String,
        var year: String,
        var image: String,
        var crew: String,
        var iMDbRating: String,
        var iMDbRatingCount: String
    )

}