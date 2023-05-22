package com.theathletic.interview.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theathletic.interview.articles.ui.ArticleDetailScreen
import com.theathletic.interview.articles.ui.ArticlesScreen
import com.theathletic.interview.articles.ui.ArticlesViewModel

//
//@Composable
//fun ArticleNavigation (viewModel: ArticlesViewModel) {
//
//    val navHostController = rememberNavController()
//
//    NavHost(
//        navController = navHostController,
//        startDestination = Navigation.ArticleList.route
//    ) {
//        composable(Navigation.ArticleList.route){
//            ArticlesScreen(viewModel = viewModel, navHostController = navHostController)
//        }
//        composable(Navigation.ArticleDetails.route){
//            ArticleDetailScreen()
//        }
//    }
//}