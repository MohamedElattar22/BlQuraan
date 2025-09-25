package com.iamelattar.blquraan.features.quraan.domain

data class Surah(
    val id: Int,
    val arabic: String,
    val aya: Int,
    val place: String,
    val startPage: Int,
)
