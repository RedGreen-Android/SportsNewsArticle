package com.theathletic.interview.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theathletic.interview.R
import com.theathletic.interview.articles.ui.ArticleDetailScreen
import com.theathletic.interview.articles.ui.ArticlesScreen
import com.theathletic.interview.articles.ui.ArticlesViewModel
import com.theathletic.interview.ui.theme.AthleticTheme
import com.theathletic.interview.utils.Navigation
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val articlesViewModel: ArticlesViewModel by viewModel()
//    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AthleticTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreenView()
                }
            }
        }
    }

//    @Composable
//    fun ArticleNavigation (viewModel: ArticlesViewModel) {
//
//        val navHostController = rememberNavController()
//
//        NavHost(
//            navController = navHostController,
//            startDestination = Navigation.ArticleList.route
//        ) {
//            composable(Navigation.ArticleList.route){
//                ArticlesScreen(viewModel = viewModel, navHostController = navHostController)
//            }
//            composable(Navigation.ArticleDetails.route){
//                ArticleDetailScreen()
//            }
//        }
//    }

    @Composable
    fun MainScreenView() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Navigation.ArticleList.route
        ) {
            composable(Navigation.ArticleList.route){
                ArticlesScreen(viewModel = articlesViewModel, navHostController = navController)
            }
            composable(Navigation.ArticleDetails.route){
                ArticleDetailScreen()
            }
        }
//        ArticleNavigation(viewModel = articlesViewModel)
        var selectedScreen by remember { mutableStateOf(Screen.Articles as Screen) }
        Scaffold(bottomBar = {
            BottomNavigation(
                selectedScreen,
            ) { screen -> selectedScreen = screen }
        }) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                when (selectedScreen) {
                    Screen.Articles -> {
                        ArticlesScreen(articlesViewModel, navController)
                        ArticleDetailScreen()
                    }
                    Screen.Leagues -> Text(
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterHorizontally),
                        text = "League List"
                    )
                }
            }
        }
    }

    @Composable
    fun BottomNavigation(selectedScreen: Screen, onScreenSelected: (Screen) -> Unit) {
        val items = listOf(Screen.Articles, Screen.Leagues)
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(selected = item == selectedScreen,
                    icon = {
                        Icon(
                            painterResource(id = item.resourceIcon), contentDescription = getString(item.resourceTitle)
                        )
                    },
                    label = { Text(text = getString(item.resourceTitle), fontSize = 10.sp) },
                    onClick = {
//                        navController.navigate(com.theathletic.interview.utils.Navigation.ArticleDetails.route)
                        onScreenSelected(item) })
            }
        }
    }

    sealed class Screen(
        @StringRes val resourceTitle: Int, @DrawableRes val resourceIcon: Int
    ) {
        object Articles : Screen(R.string.title_articles, R.drawable.ic_articles)
        object Leagues : Screen(R.string.title_leagues, R.drawable.ic_leagues)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ItemPreview() {
//    AthleticTheme {
//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//            MainScreenView()
//        }
//    }
//}
