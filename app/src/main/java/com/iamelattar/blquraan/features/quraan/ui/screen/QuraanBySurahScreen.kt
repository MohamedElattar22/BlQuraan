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
    LazyColumn(modifier = modifier) {
        if (state.isLoading) {
            item {
                Text("Loading...")
            }
        }
        items(state.surahList) { surah ->
            SurahListItem(surah = surah, modifier = Modifier)
        }
        state.error?.let { errorMessage ->
            item {
                Text("Error: $errorMessage")
            }
        }
    }
}