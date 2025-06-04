package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.features.quraan.ui.composables.QuraanFiltersAppBar
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuraanFiltersScreen(modifier: Modifier = Modifier) {

    val tabs = listOf("الأجزاء" , "السور")
    val pagerState = rememberPagerState(
        pageCount = {
            tabs.size
        }, initialPage = 0
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            QuraanFiltersAppBar(
                modifier = Modifier.statusBarsPadding(),
                tabsList = tabs ,
                pagerState = pagerState
            )
        }

    ) { innerPadding ->
        HorizontalPager(
            modifier = Modifier.padding(innerPadding),
            state = pagerState,
        ) { page ->

            when (page) {
                0 -> {
                    QuraanByJuzScreen()
                }

                1 -> {
                    QuraanBySurahScreen()
                }
            }
        }

    }


}

@Preview(showSystemUi = true)
@Composable
private fun saas() {
    BlQuraanTheme {
        QuraanFiltersScreen()
    }

}