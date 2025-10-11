package com.iamelattar.blquraan.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iamelattar.blquraan.features.home.navigation.HomeGraph
import com.iamelattar.blquraan.features.home.ui.screen.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: Any,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { slideInHorizontallyEnter() },
        popEnterTransition = { slideInVerticallyPopEnter() },
        exitTransition = { slideOutHorizontallyExit() },
        popExitTransition = { slideOutHorizontallyPopExit() },
        modifier = modifier,
    ) {
        composable<HomeGraph.HomeScreen> {
            HomeScreen()
        }
    }
}