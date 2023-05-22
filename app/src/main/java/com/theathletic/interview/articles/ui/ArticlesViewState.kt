package com.theathletic.interview.articles.ui

data class ArticlesViewState(
    val isLoading: Boolean = true,
    val articleModels: List<ArticleUiModel> = emptyList(),
)

data class ArticleDetailViewState(
    val isLoading: Boolean = true,
    val articleModels: ArticleUiModel? = null
)

sealed interface ArticleEvent {
    object ShowSomeMessage : ArticleEvent
}