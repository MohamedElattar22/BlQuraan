package com.iamelattar.blquraan.features.home.viewmodel.contracts

data class HomeScreenState(

    val hijriDate: String = "الثلاثاء , 4 صفر 1446",
    val nextPrayerName: String = "العصر",
    val hoursUntilNextPrayer: String = "3",
    val minutesUntilNextPrayer: String = "27",

    val currentSurah: String = "البقرة",
    val currentPage: String = "20",


    val surahOfTheDay: String = "يونس",
    val ayahOfTheDay: String = "وَإِذَا مَسَّ الْإِنسَانَ الضُّرُّ دَعَانَا لِجَنبِهِ أَوْ قَاعِدًا أَوْ قَائِمًا فَلَمَّا كَشَفْنَا عَنْهُ ضُرَّهُ مَرَّ كَأَن لَّمْ يَدْعُنَا إِلَىٰ ضُرٍّ مَّسَّهُ ۚ كَذَٰلِكَ زُيِّنَ لِلْمُسْرِفِينَ مَا كَانُوا يَعْمَلُونَ",

    val prayerTimes: List<PrayerTime> = listOf(
        PrayerTime("الفجر", "Fajr", "5:15", "🌙", isPassed = true),
        PrayerTime("الشروق", "Sunrise", "6:44", "🌅", isPassed = true),
        PrayerTime("الظهر", "Dhuhr", "12:53", "☀️", isPassed = true),
        PrayerTime("العصر", "Asr", "4:22", "☀️", isActive = true),
        PrayerTime("المغرب", "Maghrib", "7:01", "🌅"),
        PrayerTime("العشاء", "Isha", "8:20", "🌙")
    )

)