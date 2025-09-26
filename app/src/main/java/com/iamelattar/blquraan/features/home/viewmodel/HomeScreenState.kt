package com.iamelattar.blquraan.features.home.viewmodel

import com.iamelattar.blquraan.features.home.utils.DefaultValues
import com.iamelattar.blquraan.features.home.utils.PrayerTime

data class HomeScreenState(
    val hijriDate: String = DefaultValues.hijriDate,
    val nextPrayerName: String = DefaultValues.nextPrayerName,
    val hoursUntilNextPrayer: String = DefaultValues.hoursUntilNextPrayer,
    val minutesUntilNextPrayer: String = DefaultValues.minutesUntilNextPrayer,
    val currentSurah: String = DefaultValues.currentSurah,
    val currentPage: String = DefaultValues.currentPage,
    val surahOfTheDay: String = DefaultValues.surahOfTheDay,
    val ayahOfTheDay: String = DefaultValues.ayahOfTheDay,
    val prayerTimes: List<PrayerTime> = DefaultValues.prayerTimes,
    val loading: Boolean = false,
    val error: String? = null
)