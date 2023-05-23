package com.theathletic.interview.articles.ui.utils

sealed class Navigation (val route: String){

    object ArticleList : Navigation("ArticleList")
    object ArticleDetails : Navigation("ArticleDetails")
}