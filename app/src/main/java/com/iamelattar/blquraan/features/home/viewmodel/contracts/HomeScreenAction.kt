package com.iamelattar.blquraan.features.home.viewmodel.contracts

sealed class HomeScreenAction {
    object LoadData : HomeScreenAction()
    object ContinueReadingClicked : HomeScreenAction()
    object CopyAyahClicked : HomeScreenAction()
    data class OnFeatureClick(val feature: String) : HomeScreenAction()
}
