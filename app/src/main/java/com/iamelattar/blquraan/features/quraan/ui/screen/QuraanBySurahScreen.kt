package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.iamelattar.blquraan.features.quraan.ui.composables.SurahListItem
import com.iamelattar.blquraan.features.quraan.viewmodel.SurahScreenAction
import com.iamelattar.blquraan.features.quraan.viewmodel.SurahScreenState
import com.iamelattar.blquraan.features.quraan.viewmodel.SurahViewModel

@Composable
fun QuraanBySurahScreen(
    modifier: Modifier = Modifier,
    viewModel: SurahViewModel = hiltViewModel()

) {

    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.sendAction(SurahScreenAction.LoadSurahes)
    }
    when (state) {
        is SurahScreenState.Loading -> {
            CircularProgressIndicator()
        }

        is SurahScreenState.Success -> {
            val surahList = (state as SurahScreenState.Success).surahList
            LazyColumn(
                modifier = modifier
            ) {
                items(surahList.size) { index ->
                    SurahListItem(
                        modifier = Modifier,
                        surah = surahList[index]
                    )
                }
            }
        }

        is SurahScreenState.Error -> {
            val message = (state as SurahScreenState.Error).message
            // Show error message
            Text(text = message)
        }
    }

}

