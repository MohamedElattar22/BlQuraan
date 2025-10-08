package com.iamelattar.blquraan.features.home.utils

import com.iamelattar.blquraan.R

enum class FeatureEnum {
    QURAN,
    PRAYER_TIMES,
    TASBEEH,
    QIBLA,
    Hijri_Calendar;

    companion object {
        fun getAllFeatures(): List<Feature> {
            return listOf(
                Feature( R.string.prayer_times, R.drawable.time),
                Feature(R.string.quran, R.drawable.quran),
                Feature(R.string.qibla, R.drawable.navigation),
                Feature(R.string.sebha, R.drawable.bead),
                Feature(R.string.hijri_calender, R.drawable.hajj)
            )
        }
    }
}