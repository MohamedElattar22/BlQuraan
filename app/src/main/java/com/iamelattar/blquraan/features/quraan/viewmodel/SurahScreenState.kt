package com.iamelattar.blquraan.features.quraan.viewmodel

import com.iamelattar.blquraan.features.quraan.domain.Surah

sealed class SurahScreenState {
    object Loading : SurahScreenState()
    data class Success(val surahList: List<Surah>) : SurahScreenState()
    data class Error(val message: String) : SurahScreenState()
}