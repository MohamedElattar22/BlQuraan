package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuraanFiltersAppBar(
    tabsList: List<String>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = modifier) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            navigationIcon = {
                Box(
                    modifier = Modifier
                        .size(45.dp)
                        .padding(8.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(6.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_back),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = "",
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(R.string.quraan),
                    fontSize = 21.sp,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            },
        )
        TabRow(
            containerColor = MaterialTheme.colorScheme.background,
            selectedTabIndex = pagerState.currentPage,
        ) {
            tabsList.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index, onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.labelMedium,
                            color = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                )
            }
        }
    }
}

