package com.theathletic.interview.articles.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theathletic.interview.articles.data.Article
import com.theathletic.interview.articles.data.ArticleRepository
import com.theathletic.interview.articles.data.AuthorRepository
import com.theathletic.interview.articles.data.Authors
import com.theathletic.interview.articles.data.toUiModel
import com.theathletic.interview.core.updateState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    articleRepository: ArticleRepository,
    authorRepository: AuthorRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(ArticlesViewState())
    private val _viewEvent = MutableSharedFlow<ArticleEvent>()
    val viewState = _viewState.asStateFlow()
    val viewEvent: Flow<ArticleEvent> = _viewEvent

    private val _viewDetailState = MutableStateFlow(ArticleDetailViewState())
    val viewDetailState = _viewDetailState.asStateFlow()

    init {
        viewModelScope.launch {
            val articles = articleRepository.getArticles()
            val authors = authorRepository.getAuthors()
            onArticlesLoaded(articles, authors)

        }
    }

    private fun onArticlesLoaded(articles: List<Article>, authors: List<Authors>) {
        _viewState.updateState {
            copy(articleModels = articles.map { items ->
                items.toUiModel(authors.find {
                    items.authorId?.id == it.id
                })
            }, isLoading = false)
        }
    }
}