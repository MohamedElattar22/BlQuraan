package com.iamelattar.blquraan.features.quraan.viewmodel

sealed interface SurahScreenAction {
    object LoadSurahes : SurahScreenAction
    data class SelectSurah(val id: Int) : SurahScreenAction
    data class SearchSurah(val query: String) : SurahScreenAction
}