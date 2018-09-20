package com.example.platinumstandard.githubrepo20.Models

object Urls {

    //https://api.github.com/search/repositories?q=user:mitchtabian&sort=stars&order=desc&page=1&per_page=30
    val BaseUrl = "https://api.github.com/"

    fun getSearchUserUrl(login: String): String{
        return BaseUrl +
                "search/users?q=$login" /*+
                "&sort=stars" +
                "&order=desc" +
                "page=$page" +
                "per_page=20"*/


    }

    fun getReposUrl(page: Int): String{
        return BaseUrl + "search/repositories?q=android&page=$page&per_page=20"
    }

    fun getSearchedReposUrl(login: String, page: Int): String{
        return BaseUrl + "search/repositories?q=user:$login&page=$page&per_page=20"
    }
}