package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.ui.icons.WhatsappRealIc

@Composable
fun FeaturesRow(modifier: Modifier = Modifier, onFeatureClick: (String) -> Unit) {
    val feats = remember { FeaturesEnum.getFeaturesConfigs() }
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(feats) { feature ->
            FeatureButton(
                featureName = feature.name,
                featureIconRes = feature.resId,
                onClick = { onFeatureClick(feature.name) }
            )
        }
    }
}

data class Feature(
    val name: String,
    val resId: Int
)

enum class FeaturesEnum {
    PRAYER_TIMES,
    QIBLAH,
    SIBHA,
    TAQYWWEM
    ;

    companion object {
        fun getFeaturesConfigs(): List<Feature> {
            return listOf()
        }
    }
}


@Composable
fun FeatureButton(
    feature: FeaturesEnum,
    featureName: String,
    featureIconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
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
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(60.dp),
            imageVector = when (feature) {
                FeaturesEnum.PRAYER_TIMES -> WhatsappRealIc
                FeaturesEnum.QIBLAH -> WhatsappRealIc
                FeaturesEnum.SIBHA -> WhatsappRealIc
                FeaturesEnum.TAQYWWEM -> WhatsappRealIc
            },
            contentDescription = ""
        )
        Text(
            text = featureName,
            fontSize = 13.sp,
            color = Color(0xB3535353),
        )
    }
}
