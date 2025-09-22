package com.iamelattar.blquraan.features.home.utils

object DummyData {
    val prayerTimes: List<PrayerTime> = listOf(
        PrayerTime("الفجر", "Fajr", "5:15", "🌙", isPassed = true),
        PrayerTime("الشروق", "Sunrise", "6:44", "🌅", isPassed = true),
        PrayerTime("الظهر", "Dhuhr", "12:53", "☀️", isPassed = true),
        PrayerTime("العصر", "Asr", "4:22", "☀️", isActive = true),
        PrayerTime("المغرب", "Maghrib", "7:01", "🌅"),
        PrayerTime("العشاء", "Isha", "8:20", "🌙")
    )
}