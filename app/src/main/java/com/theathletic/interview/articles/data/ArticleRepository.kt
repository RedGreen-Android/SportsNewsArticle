package com.theathletic.interview.articles.data

import com.theathletic.interview.articles.data.remote.ArticleApi
import com.theathletic.interview.articles.data.remote.AuthorsApi

class ArticleRepository(private val articleApi: ArticleApi) {

    suspend fun getArticles(): List<Article> {
        return articleApi.getArticles().map { it.toDomain() }
    }
}