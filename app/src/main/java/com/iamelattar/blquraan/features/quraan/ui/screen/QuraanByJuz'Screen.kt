package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iamelattar.blquraan.features.quraan.ui.composables.JuzListItem
import com.iamelattar.blquraan.features.quraan.ui.composables.SurahListItem

@Composable
fun QuraanByJuzScreen(modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = modifier
    ){
        items(50) {
            JuzListItem()
        }
    }

}