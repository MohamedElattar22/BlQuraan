package com.iamelattar.blquraan.features.quraan.viewmodel

sealed interface JuzScreenAction {
    object LoadJuz : JuzScreenAction
    data class SelectJuz(val id: Int) : JuzScreenAction
}