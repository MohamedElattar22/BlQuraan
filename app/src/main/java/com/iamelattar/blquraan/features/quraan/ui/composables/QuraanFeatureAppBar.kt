package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuraanFiltersAppBar(
    modifier: Modifier = Modifier,
    tabsList: List<String>,
    pagerState: PagerState
) {
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = modifier) {
        CenterAlignedTopAppBar(
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = ""
                )
            },
            title = {
                Text(
                    text = stringResource(R.string.quraan),
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF187072)
                )
            },
        )
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.height(48.dp),
        ) {
            tabsList.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            fontSize = 18.sp,
                            color = if(pagerState.currentPage == index) Color(0xFF187072) else Color.Black,
                            fontWeight = if(pagerState.currentPage == index) FontWeight.Bold else FontWeight.Medium
                        )

                    }
                )
            }
        }
    }
}