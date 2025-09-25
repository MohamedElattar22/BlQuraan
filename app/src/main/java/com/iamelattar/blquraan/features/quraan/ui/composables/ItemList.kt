package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.features.quraan.domain.Surah
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme

@Composable
fun SurahRowItem(
    modifier: Modifier = Modifier,
    surah: Surah
) {
    Row(
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFE7EAEA))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "سورة ${surah.arabic}",
                color = Color(0xff187072)
            )
            Text(
                text = "آياتها ${surah.aya} - ${surah.place}",
                color = Color(0xff4B4F50),
                fontFamily = FontFamily(Font(R.font.uthmanic_hafs))
            )
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.surah_number_ic),
                contentDescription = null
            )
            Text(
                text = surah.startPage.toString(),
                color = Color(0xff187072)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemListPreview() {
    BlQuraanTheme {
        SurahRowItem(
            modifier = Modifier
                .fillMaxWidth(),
            surah = Surah(
                1,
                "الفاتحة",
                33,
                "7",
                1,

                )
        )

    }

}