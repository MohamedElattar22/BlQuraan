package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.iamelattar.blquraan.features.quraan.ui.composables.JuzListItem
import com.iamelattar.blquraan.features.quraan.viewmodel.JuzScreenState
import com.iamelattar.blquraan.features.quraan.viewmodel.JuzViewModel

@Composable
fun QuraanByJuzScreen(
    modifier: Modifier = Modifier,
    viewModel: JuzViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = modifier
    ) {

        if (state is JuzScreenState.Success) {
            val juzList = (state as JuzScreenState.Success).juzList
            items(juzList.size) { index ->
                JuzListItem(
                    modifier = Modifier,
                    juz = juzList[index]
                )
            }
        }

    }

}