package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.features.quraan.domain.entities.Surah

@Composable
fun SurahListItem(
    surah: Surah,
    modifier: Modifier = Modifier,
) {
    ListItem(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 4.dp
            )
            .clip(RoundedCornerShape(10.dp)),
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            headlineColor = MaterialTheme.colorScheme.primary,
            leadingIconColor = MaterialTheme.colorScheme.primary,
        ),
        headlineContent = {
            Text(
                text = buildString {
                    append(stringResource(id = R.string.surah))
                    append(" ")
                    append(surah.arabic)
                },
                color = Color(0xff187072),
                fontSize = 14.sp
            )
        },
        supportingContent = {
            Text(
                text = buildString {
                    append(stringResource(id = R.string.ayah))
                    append(" ")
                    append(surah.aya)
                    append(" ")
                    append("-")
                    append(" ")
                    append(surah.surahPlace)
                },
                color = MaterialTheme.colorScheme.surfaceBright,
                fontSize = 12.sp,
                fontFamily = FontFamily(
                    Font(R.font.uthmanic_hafs)
                ),
            )
        },
        trailingContent = {
            Text(
                text = buildString {
                    append(stringResource(R.string.page))
                    append(" ")
                    append(surah.startPage)
                },
                color = MaterialTheme.colorScheme.surfaceBright,
                fontSize = 14.sp,
                style = MaterialTheme.typography.displaySmall
            )
        }
    )
}