package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iamelattar.blquraan.features.quraan.ui.composables.SurahListItem
import com.iamelattar.blquraan.features.quraan.viewmodel.SurahViewModel

@Composable
fun QuraanBySurahScreen(
    viewModel: SurahViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }

            else -> {
                LazyColumn {
                    items(state.surahList) { surah ->
                        SurahListItem(surah = surah, modifier = Modifier)
                    }
                }
            }
        }
    }
}