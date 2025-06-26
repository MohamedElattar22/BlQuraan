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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme

@Composable
fun FeaturesRow(
    modifier: Modifier = Modifier,
    onClick: () -> Unit ={}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        FeatureButton(
            onClick = {
                onClick()
            },
            featureName = "المصحف",
            featureIconRes = R.drawable.quran
        )
    }

}

@Composable
fun FeatureButton(
    modifier: Modifier = Modifier,
    onClick : ()-> Unit = {},
    featureName: String,
    featureIconRes: Int
) {

    Column(
        modifier = modifier.clickable{
            onClick()
        },
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
            color = Color(0xB3535353)
        )

    }

}
