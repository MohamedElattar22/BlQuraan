package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iamelattar.blquraan.features.quraan.ui.composables.SurahListItem
import com.iamelattar.blquraan.features.quraan.viewmodel.SurahViewModel

@Composable
fun QuraanBySurahScreen(
    modifier: Modifier = Modifier,
    viewModel: SurahViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    when {
        state.isLoading -> {
            Text("Loading...")
        }

        state.error != null -> {
            Text("Error: ${state.error}")
        }

        else -> {
            LazyColumn(modifier = modifier) {
                items(state.surahList) { sura ->
                    SurahListItem(modifier = Modifier, surah = sura)
                }
            }
        }
    }
}

