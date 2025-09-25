package com.iamelattar.blquraan.features.quraan.ui.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.features.quraan.ui.composables.QuraanFiltersAppBar
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import com.iamelattar.blquraan.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuraanFiltersScreen(modifier: Modifier = Modifier) {

    val tabs = listOf("الأجزاء", "السور")
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
                tabsList = tabs,
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