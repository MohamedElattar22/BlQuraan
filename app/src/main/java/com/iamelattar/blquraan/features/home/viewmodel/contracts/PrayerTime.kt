package com.iamelattar.blquraan.features.home.viewmodel.contracts

data class PrayerTime(
    val nameArabic: String,
    val nameEnglish: String,
    val time: String,
    val icon: String,
    val isActive: Boolean = false,
    val isPassed: Boolean = false
)