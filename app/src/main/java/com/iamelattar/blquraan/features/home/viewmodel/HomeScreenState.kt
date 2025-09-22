package com.iamelattar.blquraan.features.home.viewmodel

import com.iamelattar.blquraan.features.home.utils.DummyData
import com.iamelattar.blquraan.features.home.utils.PrayerTime

data class HomeScreenState(
    val hijriDate: String = "الثلاثاء , 4 صفر 1446",
    val nextPrayerName: String = "العصر",
    val hoursUntilNextPrayer: String = "3",
    val minutesUntilNextPrayer: String = "27",
    val currentSurah: String = "البقرة",
    val currentPage: String = "20",
    val surahOfTheDay: String = "يونس",
    val ayahOfTheDay: String = "وَإِذَا مَسَّ الْإِنسَانَ الضُّرُّ دَعَانَا لِجَنبِهِ أَوْ قَاعِدًا أَوْ قَائِمًا فَلَمَّا كَشَفْنَا عَنْهُ ضُرَّهُ مَرَّ كَأَن لَّمْ يَدْعُنَا إِلَىٰ ضُرٍّ مَّسَّهُ ۚ كَذَٰلِكَ زُيِّنَ لِلْمُسْرِفِينَ مَا كَانُوا يَعْمَلُونَ",
    val prayerTimes: List<PrayerTime> = DummyData.prayerTimes,
    val loading : Boolean = false,
    val error :String ? = null // error -> empty , error -> has data , error -> null
)
// state -> lists - strings - floats - data class
// 2types -> loading
// errors -> string