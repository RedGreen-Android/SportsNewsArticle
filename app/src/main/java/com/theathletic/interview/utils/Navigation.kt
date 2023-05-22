package com.theathletic.interview.utils

sealed class Navigation (val route: String){

    object ArticleList : Navigation("ArticleList")
    object ArticleDetails : Navigation("ArticleDetails")
}