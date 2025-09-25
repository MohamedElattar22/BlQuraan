package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.features.quraan.domain.Surah
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import com.iamelattar.blquraan.ui.theme.SecondaryColor

@Composable
fun SurahListItem(
    modifier: Modifier = Modifier,
    surah: Surah

) {
    ListItem(
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            ,
        colors = ListItemDefaults.colors(
            containerColor = SecondaryColor
        ),
        headlineContent = {
            Text(
                text = stringResource(id = R.string.surah) + " " + surah.arabic,
                color = Color(0xff187072)
            )
        },

        supportingContent = {
            Text(
                text = stringResource(id = R.string.ayah) + " " + surah.aya + " - " + surah.place,
                fontFamily = FontFamily(
                    Font(R.font.uthmanic_hafs)
                ),
                color = Color(0xff4B4F50),
            )
        },
        trailingContent = {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(
                        CircleShape
                    )

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

@Preview(showBackground = true)
@Composable
fun ListItemPrev(modifier: Modifier = Modifier) {
    BlQuraanTheme {
        SurahListItem(
            modifier = modifier,
            surah = Surah(
                1,
                "الفاتحة",

                7,
                "Al-Fatiha",
                1,
            )
        )
    }

}