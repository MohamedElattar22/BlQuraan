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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.features.home.ui.composables.AyahOfTheDay
import com.iamelattar.blquraan.features.home.ui.composables.CurrentSurahProgress
import com.iamelattar.blquraan.features.home.ui.composables.FeaturesRow
import com.iamelattar.blquraan.features.home.ui.composables.PrayerTimesTimeline
import com.iamelattar.blquraan.features.home.ui.composables.TopAppBar
import com.iamelattar.blquraan.features.home.viewmodel.HomeScreenAction
import com.iamelattar.blquraan.features.home.viewmodel.HomeViewModel
import androidx.compose.runtime.getValue
import com.iamelattar.blquraan.features.home.utils.BlQuraanFeatures

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (BlQuraanFeatures) -> Unit,
    onAction: (HomeScreenAction) -> Unit = viewModel::sendAction
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                hijriDate = state.hijriDate,
                hoursUntilNextPrayer = state.hoursUntilNextPrayer,
                minutesUntilNextPrayer = state.minutesUntilNextPrayer,
                nextPrayerName = state.nextPrayerName
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            CurrentSurahProgress(
                modifier = Modifier.padding(horizontal = 10.dp),
                souraName = state.currentSurah,
                pageNumber = state.currentPage
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = stringResource(R.string.features),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            FeaturesRow(
                modifier = Modifier.padding(horizontal = 10.dp),
                onFeatureClick = { feature ->
                    onNavigate(feature)
                }
            )
            AyahOfTheDay(
                modifier = Modifier.padding(horizontal = 10.dp),
                souraOfTheDay = state.surahOfTheDay,
                ayahText = state.ayahOfTheDay,
                onClick = {}
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = stringResource(R.string.prayer_times),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            PrayerTimesTimeline(prayerTimes = state.prayerTimes)
            Spacer(Modifier.height(5.dp))
        }
    }
}