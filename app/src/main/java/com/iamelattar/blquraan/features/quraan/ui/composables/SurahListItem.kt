package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
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
                    append(surah.place)
                },
                color = Color(0xff4B4F50),
                fontSize = 11.sp,
                fontFamily = FontFamily(
                    Font(R.font.uthmanic_hafs)
                ),
            )
        },
        trailingContent = {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    imageVector = ImageVector.vectorResource(R.drawable.surah_number_ic),
                    contentDescription = "",
                    alignment = Alignment.CenterEnd
                )
                Text(
                    text = surah.startPage.toString(),
                    color = Color(0xff187072),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    )
}