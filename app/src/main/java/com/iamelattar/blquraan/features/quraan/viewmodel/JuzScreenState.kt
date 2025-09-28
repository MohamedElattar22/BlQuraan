package com.iamelattar.blquraan.features.quraan.viewmodel

import com.iamelattar.blquraan.features.quraan.domain.entities.Juz

data class JuzScreenState(
    val juzList: List<Juz> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedJuz: Juz? = null
)