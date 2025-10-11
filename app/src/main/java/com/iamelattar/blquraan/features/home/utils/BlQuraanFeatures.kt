package com.iamelattar.blquraan.features.home.utils

import androidx.annotation.StringRes
import com.iamelattar.blquraan.R

enum class BlQuraanFeatures(@StringRes val stringId: Int, val iconId: Int) {
    QURAN(R.string.quran, R.drawable.quran),
    PRAYER_TIMES(R.string.prayer_times, R.drawable.time),
    TASBEEH(R.string.sebha, R.drawable.bead),
    QIBLA(R.string.qibla, R.drawable.navigation),
    HIJRI_CALENDER(R.string.hijri_calender, R.drawable.hajj)
    ;
}