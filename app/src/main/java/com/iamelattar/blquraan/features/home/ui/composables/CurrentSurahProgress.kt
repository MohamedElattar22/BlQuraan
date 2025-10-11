package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R

@Composable
fun CurrentSurahProgress(
    souraName: String,
    pageNumber: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.back_progress_with_logo),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.TopStart),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.continue_reading),
                color = Color.White
            )
            Row {
                Text(
                    text = stringResource(R.string.stopped_at),
                    color = Color(0xB3FFFFFF),
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 14.sp,
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = buildString {
                        append(stringResource(R.string.soura))
                        append("")
                        append(souraName)
                    },
                    color = Color(0xff02B9BD),
                    modifier = Modifier.alignByBaseline()
                )
            }
            Row {
                Text(
                    text = stringResource(R.string.page_number),
                    color = Color(0xB3FFFFFF),
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 14.sp,
                    modifier = Modifier.alignByBaseline()
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    pageNumber,
                    color = Color(0xff02B9BD),
                    modifier = Modifier.alignByBaseline()
                )
            }
            Spacer(Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .width(115.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { onClick }
                    .padding(vertical = 5.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(R.string.follow_up),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}