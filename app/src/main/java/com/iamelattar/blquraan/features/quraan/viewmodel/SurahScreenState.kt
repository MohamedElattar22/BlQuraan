package com.iamelattar.blquraan.features.quraan.viewmodel

import com.iamelattar.blquraan.features.quraan.domain.entities.Surah

data class SurahScreenState(
    val surahList: List<Surah> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedSurah: Surah? = null
)
