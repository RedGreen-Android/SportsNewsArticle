package com.theathletic.interview.articles.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.theathletic.interview.core.collectWithLifecycle
import com.theathletic.interview.ui.theme.Black
import com.theathletic.interview.ui.theme.Orange200
import com.theathletic.interview.ui.theme.White
import org.koin.androidx.compose.getViewModel


@Composable
fun ArticleDetailScreen(
    viewModel: ArticlesViewModel = getViewModel(),
    ){
//    Box(modifier = Modifier.fillMaxSize()) {
//        Text(
//        text = "Details")
//}
    val viewDetailState by viewModel.viewDetailState.collectAsState(initial = ArticleDetailViewState(true))

    viewModel.viewEvent.collectWithLifecycle { //event->
//        when (event){
//          here you can handle one-off events
//        }
    }

    viewDetailState.articleModels?.let { ArticleDetails(showLoading = viewDetailState.isLoading, models = it) }
}

@Composable
fun ArticleDetails(models: ArticleUiModel, showLoading: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
            .height(200.dp)
    ) {
        AsyncImage(
            alpha = 0.5f,
            modifier = Modifier.fillMaxWidth(),
            model = models.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            alpha = 0.5f,
            modifier = Modifier.size(100.dp),
            model = models.authorImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = models.title,
                style = MaterialTheme.typography.body1,
                color = White
            )
            Text(
                text = models.author ?: "",
                style = MaterialTheme.typography.caption,
                color = Orange200,
                fontSize = 15.sp
            )
            Text(
                text = models.body ?: "",
                style = MaterialTheme.typography.caption,
                color = White
            )
        }
    }
}

//@Preview
//@Composable
//fun ArticleItemPreview(models: ArticleUiModel, showLoading: Boolean) {
//    ArticleDetails(models = ArticleUiModel(
//        title = models.title,
//        imageUrl = models.imageUrl,
//        updatedAt = models.updatedAt,
//        ), showLoading = false)
//}
