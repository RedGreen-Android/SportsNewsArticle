package com.theathletic.interview.articles.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.theathletic.interview.articles.data.Article.Companion.UNKNOWN
import com.theathletic.interview.articles.data.remote.ArticleApiModel
import com.theathletic.interview.articles.data.remote.AuthorsApi
import com.theathletic.interview.articles.data.remote.AuthorsApiModel
import com.theathletic.interview.articles.ui.ArticleUiModel

fun ArticleApiModel.toDomain() = Article(
    id = id,
    title = title,
    body = body ?: UNKNOWN,
    teamId = teamId ?: UNKNOWN,
    leagueId = leagueId ?: UNKNOWN,
    authorId = authorId ?: UNKNOWN,
    imageUrl = imageUrlString ?: ""
)

fun Article.toUiModel(author: Authors?) = ArticleUiModel(
    title = title,
    imageUrl = imageUrl,
    authorImageUrl = author?.imageUrl,
    displayAuthor = true,
    updatedAt = author?.updatedAt,
    author = author?.shortname
)

fun AuthorsApiModel.toDomain() = Authors(
    id = id,
    body = body ?: "",
    updatedAt = updatedAt ,
    title = title,
    shortname = shortname,
    createdAt = createdAt?: "",
    imageUrl = imageUrlString ?: "",
)

//fun Authors.toUiModel() = ArticleUiModel(
//    title = "",
//    author = id,
//    authorImageUrl = imageUrl,
//    displayAuthor = true,
//    updatedAt = updatedAt,
//    imageUrl = imageUrl
//
//    )