package com.iamelattar.blquraan.features.quraan.viewmodel

import com.iamelattar.blquraan.features.quraan.domain.Juz

sealed class JuzScreenState {
    object Loading : JuzScreenState()
    data class Success(val juzList: List<Juz>) : JuzScreenState()
    data class Error(val message: String) : JuzScreenState()
}