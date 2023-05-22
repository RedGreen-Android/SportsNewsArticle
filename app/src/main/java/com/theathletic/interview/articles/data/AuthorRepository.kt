package com.theathletic.interview.articles.data

import com.theathletic.interview.articles.data.remote.AuthorsApi

class AuthorRepository (private val authorsApi: AuthorsApi) {

    suspend fun getAuthors(): List<Authors> {
        return authorsApi.getAuthors().map { it.toDomain() }
    }
}