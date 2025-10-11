package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R

@Composable
fun TopAppBar(
    hijriDate: String,
    hoursUntilNextPrayer: String,
    minutesUntilNextPrayer: String,
    nextPrayerName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )
            .height(130.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )
            .clip(
                shape = RoundedCornerShape(
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )
    ) {
        val isDarkTheme = isSystemInDarkTheme()
        Image(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        bottomEnd = 30.dp,
                        bottomStart = 30.dp
                    )
                )
                .fillMaxSize(),
            painter = if (!isDarkTheme) painterResource(R.drawable.islamic_bg) else painterResource(
                R.drawable.background_dark
            ),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        Row(
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.BottomStart),
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = stringResource(R.string.welcome_back),
                    color = Color(0xff187072),
                    style = MaterialTheme.typography.headlineMedium
                )
                IconText(
                    text = hijriDate,
                    iconResourceId = R.drawable.calender
                )
                IconText(
                    text = "صلاة $nextPrayerName بعد ${hoursUntilNextPrayer} ساعات و ${minutesUntilNextPrayer} دقيقة",
                    iconResourceId = R.drawable.prayer
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End,
            ) {
                Spacer(Modifier.height(15.dp))
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.logo),
                    contentDescription = "sa"
                )
            }
        }
    }
}


