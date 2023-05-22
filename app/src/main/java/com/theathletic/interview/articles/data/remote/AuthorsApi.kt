package com.theathletic.interview.articles.data.remote

import retrofit2.http.GET

interface AuthorsApi {

    @GET("authors")
    suspend fun getAuthors(): List<AuthorsApiModel>
}