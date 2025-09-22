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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.features.home.ui.composables.AyahOfTheDay
import com.iamelattar.blquraan.features.home.ui.composables.CurrentSurahProgress
import com.iamelattar.blquraan.features.home.ui.composables.FeaturesRow
import com.iamelattar.blquraan.features.home.ui.composables.PrayerTimesTimeline
import com.iamelattar.blquraan.features.home.ui.composables.TopAppBar
import com.iamelattar.blquraan.features.home.viewmodel.contracts.HomeScreenAction.OnFeatureClick
import com.iamelattar.blquraan.features.home.viewmodel.contracts.HomeViewModel

@Composable
fun HomeScreen  (modifier: Modifier = Modifier,
                 viewModel: HomeViewModel = hiltViewModel() ) {
    val state = viewModel.state.collectAsState()
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                modifier = Modifier,
                hijriDate = state.value.hijriDate,
                hoursUntilNextPrayer = state.value.hoursUntilNextPrayer,
                minutesUntilNextPrayer = state.value.minutesUntilNextPrayer,
                nextPrayerName = state.value.nextPrayerName
            )
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
                    modifier = Modifier.padding(horizontal = 10.dp),
                    souraName = state.value.currentSurah,
                    pageNumber = state.value.currentPage
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = stringResource(R.string.features),
                    fontWeight = FontWeight.Bold
                )

                FeaturesRow(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    onFeatureClick = { feature ->viewModel.onAction(OnFeatureClick(feature))}
                )

                AyahOfTheDay(modifier = Modifier.padding(horizontal = 10.dp),
                    souraOfTheDay = state.value.surahOfTheDay,
                    ayahText = state.value.ayahOfTheDay
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    text = stringResource(R.string.prayer_times),
                    fontWeight = FontWeight.Bold
                )

                PrayerTimesTimeline(prayerTimes = state.value.prayerTimes)

                Spacer(modifier = Modifier.height(5.dp))
            }
        }


}