package com.android.movies.search


data class SearchMovie (
    var searchType: String,
    var expression: String,

    var results: List<SearchList>,
    var errorMessage: String
){
    data class SearchList (
        var id: String,
        var resultType: String,
        var image: String,
        var title: String,
        var description: String,
    )

}


