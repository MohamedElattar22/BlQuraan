package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iamelattar.blquraan.features.quraan.ui.composables.QuraanFiltersAppBar
import com.iamelattar.blquraan.features.quraan.ui.model.QuraanTab

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuraanFiltersScreen(modifier: Modifier = Modifier) {

    val tabs = QuraanTab.entries
    val pagerState = rememberPagerState(
        pageCount = { tabs.size },
        initialPage = 0
    )
    Scaffold(
        modifier = modifier,
        topBar = {
            QuraanFiltersAppBar(
                modifier = Modifier.statusBarsPadding(),
                tabsList = tabs.map { it.title },
                pagerState = pagerState
            )
        }
    ) { innerPadding ->

        HorizontalPager(
            modifier = Modifier.padding(innerPadding),
            state = pagerState,
        ) { page ->

            when (tabs[page]) {
                QuraanTab.JUZ -> QuraanByJuzScreen()
                QuraanTab.SURAH -> QuraanBySurahScreen()
            }
        }
    }
}
