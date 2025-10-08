package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iamelattar.blquraan.features.quraan.ui.composables.JuzListItem
import com.iamelattar.blquraan.features.quraan.viewmodel.JuzViewModel

@Composable
fun QuraanByJuzScreen(
    modifier: Modifier = Modifier,
    viewModel: JuzViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LazyColumn(modifier = modifier) {
        if (state.isLoading) {
            item {
                Text("Loading...")
            }
        }
        items(state.juzList) { juz ->
            JuzListItem(juz = juz, modifier = Modifier)
        }
        state.error?.let { errorMessage ->
            item {
                Text("Error: $errorMessage")
            }
        }
    }
}