package com.iamelattar.blquraan.features.quraan.ui.composables

import android.graphics.pdf.models.ListItem
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme

@Composable
fun SurahListItem(modifier: Modifier = Modifier) {
    ListItem(
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = ListItemDefaults.colors(
            containerColor = Color(0xffE7EAEA)
        ),
        headlineContent = {
            Text(
               text =  "سورة الفاتحة",
                color = Color(0xff187072)
            )
        },

        supportingContent = {
            Text(
                text = "آياتها 7" ,
                fontFamily = FontFamily(
                    Font(R.font.uthmanic_hafs)
                ) ,
                color = Color(0xff4B4F50),
            )
        },
        leadingContent = {
            Box(
                modifier = Modifier.size(40.dp).clip(
                    CircleShape
                )

            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center) ,
                    imageVector = ImageVector.vectorResource(R.drawable.surah_number_ic),
                    contentDescription = ""
                )
                Text(
                   text =  "1" ,
                    color = Color(0xff187072) ,
                    modifier = Modifier.align(Alignment.Center)

                )

            }
        }
    )

}
@Preview
@Composable
fun ListItemPrev(modifier: Modifier = Modifier) {
    BlQuraanTheme {
        SurahListItem()
    }

}