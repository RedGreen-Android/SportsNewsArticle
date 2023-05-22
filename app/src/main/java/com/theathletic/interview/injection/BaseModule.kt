package com.theathletic.interview.injection

import com.theathletic.interview.articles.data.ArticleRepository
import com.theathletic.interview.articles.data.AuthorRepository
import com.theathletic.interview.articles.data.remote.ArticleApi
import com.theathletic.interview.articles.data.remote.AuthorsApi
import com.theathletic.interview.articles.ui.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val baseModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://mobile-interview-backend.theathletic.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { get<Retrofit>().create(ArticleApi::class.java) }

    factory { get<Retrofit>().create(AuthorsApi::class.java) }

    single { ArticleRepository(get()) }

    single { AuthorRepository(get()) }

    viewModel { ArticlesViewModel(get(), get()) }

}