package com.theathletic.interview.articles.data.remote

data class AuthorsApiModel (
    val id: String,
    val body: String?,
    val updatedAt: String,
    val title: String,
    val shortname: String,
    val createdAt: String?,
    val imageUrlString: String?
    )