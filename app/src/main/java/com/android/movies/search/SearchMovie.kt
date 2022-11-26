package com.android.movies.search


class SearchMovie (
    var searchType: String,
    var expression: String,

    var results: List<SearchList>,
    var errorMessage: String
){
    class SearchList (
        var id: String,
        var resultType: String,
        var image: String,
        var title: String,
        var description: String,
    )

}


