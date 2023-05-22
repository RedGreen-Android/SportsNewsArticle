package com.theathletic.interview.articles.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.theathletic.interview.articles.data.remote.ArticleAuthor
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Article(
    val id: String,
    val body: String,
    val teamId: String,
    val leagueId: String,
    val title: String,
    val imageUrl: String,
    val authorId: ArticleAuthor?
) {
    companion object {
        const val UNKNOWN = ""
    }

}


//    @RequiresApi(Build.VERSION_CODES.O)
//    val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    val format = LocalDate.parse(updatedAt.toString(), firstApiFormat)

//    @RequiresApi(Build.VERSION_CODES.O)
//    val date = LocalDate.parse(updatedAt , firstApiFormat)