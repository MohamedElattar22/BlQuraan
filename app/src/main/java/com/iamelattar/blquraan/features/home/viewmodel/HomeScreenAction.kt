package com.iamelattar.blquraan.features.home.viewmodel

sealed interface HomeScreenAction {
    data object LoadData : HomeScreenAction
    data object ResetError : HomeScreenAction
}