package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R

@Composable
fun FeaturesRow(modifier: Modifier = Modifier,onFeatureClick: (String) -> Unit) {
    val features = listOf(
        "مواقيت الصلاة" to R.drawable.time,
        "المصحف" to R.drawable.quran,
        "  اتجاه القبلة  " to R.drawable.navigation,
        "السبحة" to R.drawable.bead,
        "التقويم الهجري" to R.drawable.hajj
    )

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(features.size) { it ->
            FeatureButton(
                featureName = features[it].first,
                featureIconRes = features[it].second,
                onClick = { onFeatureClick(features[it].first) }
            )
        }
    }
}


@Composable
fun FeatureButton(
    featureName: String,
    featureIconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable{ onClick() },
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(65.dp)
                .background(
                    color = Color(0xffF4F4F4),
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0x33187072),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.Center),
                painter = painterResource(featureIconRes),
                contentDescription = ""
            )
        }
            Text(
                text = featureName,
                fontSize = 13.sp,
                color = Color(0xB3535353),
            )


    }

}
