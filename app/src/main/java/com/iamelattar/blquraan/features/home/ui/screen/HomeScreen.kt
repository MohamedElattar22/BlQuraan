package com.iamelattar.blquraan.features.home.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.features.home.ui.composables.AyahOfTheDay
import com.iamelattar.blquraan.features.home.ui.composables.CurrentSurahProgress
import com.iamelattar.blquraan.features.home.ui.composables.FeaturesRow
import com.iamelattar.blquraan.features.home.ui.composables.PrayerTimesTimeline
import com.iamelattar.blquraan.features.home.ui.composables.TopAppBar
import com.iamelattar.blquraan.features.home.viewmodel.contracts.PrayerTime

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar()
        }
    ) { innerPadding->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(color = Color(0xFFF4F4F4))
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                Spacer(modifier = Modifier.height(5.dp))
                CurrentSurahProgress(
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = stringResource(R.string.features),
                    fontWeight = FontWeight.Bold
                )

                FeaturesRow(
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                AyahOfTheDay(modifier = Modifier.padding(horizontal = 10.dp))

                val samplePrayerTimes = listOf(
                    PrayerTime("الفجر", "Fajr", "5:15", "🌙", isPassed = true),
                    PrayerTime("الشروق", "Sunrise", "6:44", "🌅", isPassed = true),
                    PrayerTime("الظهر", "Dhuhr", "12:53", "☀️", isPassed = true),
                    PrayerTime("العصر", "Asr", "4:22", "☀️", isActive = true),
                    PrayerTime("المغرب", "Maghrib", "7:01", "🌅"),
                    PrayerTime("العشاء", "Isha", "8:20", "🌙")
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = stringResource(R.string.prayer_times),
                    fontWeight = FontWeight.Bold
                )

                PrayerTimesTimeline(prayerTimes = samplePrayerTimes)

                Spacer(modifier = Modifier.height(5.dp))
            }
        }


}