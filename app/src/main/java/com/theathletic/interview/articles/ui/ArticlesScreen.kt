package com.theathletic.interview.articles.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.android.material.internal.NavigationMenu
import com.theathletic.interview.articles.data.remote.AuthorsApiModel
import com.theathletic.interview.core.collectWithLifecycle
import com.theathletic.interview.ui.theme.Black
import com.theathletic.interview.ui.theme.Orange200
import com.theathletic.interview.ui.theme.White
import org.koin.androidx.compose.getViewModel

class ArticleUiModel(
    val title: String,
    val author: String? = null,
    val displayAuthor: Boolean = false,
    val imageUrl: String?,
    val authorImageUrl : String? = null,
    val updatedAt : String?,
    val body : String? = null,
)

@Composable
fun ArticlesScreen(
    viewModel: ArticlesViewModel = getViewModel(),
    navHostController: NavHostController
) {

    val state by viewModel.viewState.collectAsState(initial = ArticlesViewState(true, emptyList()))

    viewModel.viewEvent.collectWithLifecycle { //event->
//        when (event){
//          here you can handle one-off events
//        }
    }

    ArticlesList(showLoading = state.isLoading, models = state.articleModels, navHostController)
}

@Composable
fun ArticlesList(showLoading: Boolean, models: List<ArticleUiModel>, navController: NavHostController

) {
    Box {
        if (showLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            items(models) {
                Surface(modifier = Modifier.clickable {
//                    navHostController.navigate(com.theathletic.interview.utils.Navigation.ArticleDetails.route)
                }) {
                    ArticleItem(it,navController )

//                    navHostController.navigate(com.theathletic.interview.utils.Navigation.ArticleDetails.route)
                }

            }
        }
    }
}

@Composable
fun ArticleItem(model: ArticleUiModel, navHostController: NavHostController,
                ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Black)
            .height(200.dp)
            .clickable {
//                onGettingClick
                navHostController.navigate(route = com.theathletic.interview.utils.Navigation.ArticleDetails.route)
                Log.d("HIT", "now hit")
//                onItemClicked()
            }
    ) {
        AsyncImage(
            alpha = 0.5f,
            modifier = Modifier.fillMaxSize(),
            model = model.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            alpha = 0.5f,
            modifier = Modifier.size(100.dp),
            model = model.authorImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .clickable {
                    navHostController.navigate(com.theathletic.interview.utils.Navigation.ArticleDetails.route)
                }
                .padding(10.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = model.title,
                style = MaterialTheme.typography.body1,
                color = White
            )
            if (model.displayAuthor) {
                Text(
                    text = model.author ?: "",
                    style = MaterialTheme.typography.caption,
                    color = Orange200,
                    fontSize = 15.sp
                )
                Text(
                    text = model.updatedAt ?: "",
                    style = MaterialTheme.typography.caption,
                    color = White
                )
            }
        }
    }
}

//@Preview(backgroundColor = 0xFFffffff, showBackground = true, name = "Article")
//@Composable
//fun ArticleItemPreview() {
//    ArticleItem(
//        ArticleUiModel(
//            "Sample Title",
//            imageUrl = null,
//            author = "Sample Author Name",
//            authorImageUrl = null,
//            updatedAt = "updated at: "
//        )
//    )
//}