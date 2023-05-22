package com.theathletic.interview.articles.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import coil.compose.AsyncImage
import com.theathletic.interview.ui.theme.Black
import com.theathletic.interview.ui.theme.White

@Composable
fun ArticleDetailScreen(){
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
        text = "Details")
}

//    val state by viewModel.viewState.collectAsState(initial = ArticlesViewState(true, emptyList()))
//
//    viewModel.viewEvent.collectWithLifecycle { //event->
////        when (event){
////          here you can handle one-off events
////        }
//    }
//
//    ArticlesList(showLoading = state.isLoading, models = state.articleModels)
}

//@Composable
//fun ArticleDetailsList(showLoading: Boolean, models: List<ArticleUiModel>) {
//    Box {
//        if (showLoading) {
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator()
//            }
//        }
//        LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
//            items(models) {
//                ArticleItem(it) }
//        }
//    }
//}
//
//@Composable
//fun ArticleDetailItem(model: ArticleUiModel) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = Black)
//            .height(200.dp)
//    ) {
//        AsyncImage(
//            alpha = 0.5f,
//            modifier = Modifier.fillMaxSize(),
//            model = model.imageUrl,
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
//        AsyncImage(
//            alpha = 0.5f,
//            modifier = Modifier.size(100.dp),
//            model = model.authorImageUrl,
//            contentDescription = null,
//            contentScale = ContentScale.Crop
//        )
//        Column(
//            modifier = Modifier
//                .padding(10.dp)
//                .align(Alignment.BottomStart)
//        ) {
//            Text(
//                text = model.title,
//                style = MaterialTheme.typography.body1,
//                color = White
//            )
//            Text(
//                text = model.author ?: "",
//                style = MaterialTheme.typography.caption,
//                color = Black,
//                fontSize = 15.sp
//            )
//            Text(
//                text = model.updatedAt ?: "",
//                style = MaterialTheme.typography.caption,
//                color = White
//            )
//            Text(
//                text = model.authorId ?: "",
//                style = MaterialTheme.typography.caption,
//                color = White
//            )
//        }
//    }
//}

@Preview(backgroundColor = 0xFFffffff, showBackground = true, name = "Article")
@Composable
fun ArticleItemPreview() {
    ArticleDetailScreen()
}
