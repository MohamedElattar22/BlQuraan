package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.features.home.utils.FeatureEnum
import androidx.compose.foundation.lazy.items


@Composable
fun FeaturesRow(onFeatureClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    val features = remember { FeatureEnum.getAllFeatures() }

    LazyRow(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(features) { feature ->
            FeatureButton(
                featureName = stringResource(feature.nameRes),
                featureIconRes = feature.resourceId,
                onClick = { onFeatureClick(feature.nameRes) }
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
        modifier = modifier.clickable { onClick() },
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
