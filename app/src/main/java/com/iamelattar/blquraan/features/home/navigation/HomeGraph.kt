package com.iamelattar.blquraan.features.home.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface HomeGraph {
    @Serializable
    data object Route: HomeGraph
    @Serializable
    data object HomeScreen: HomeGraph
}