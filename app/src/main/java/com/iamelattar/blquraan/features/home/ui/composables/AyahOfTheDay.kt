package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp

@Composable
fun AyahOfTheDay(modifier: Modifier = Modifier,souraOfTheDay:String,ayahText:String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .background(
                color = Color(0xffE7EFF2),
                shape = RoundedCornerShape(14.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0x33187072),
                shape = RoundedCornerShape(14.dp)
            ).padding(bottom = 10.dp)
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(
                    "آية اليوم",
                    color = Color(0xff398E71)
                )

                Text(
                    text = "سورة ${souraOfTheDay}",
                    color = Color(0xff398E71)
                )

            }

            Text(
                modifier = Modifier.padding(horizontal =  10.dp),
                text = ayahText,
                fontFamily = FontFamily(
                    Font(R.font.uthmanic_hafs)
                ),
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )

            OutlinedButton(
                onClick = {

                },
                border = BorderStroke(
                    width = 1.dp ,
                    color = Color(0xff398E71)
                ),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                shape = RoundedCornerShape(10.dp)
            ) {

                Text(
                    "نسخ الآية",
                    color = Color(0xff398E71)
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.solar_copy),
                    contentDescription = "copy",
                    tint = Color(0xff398E71)
                )


            }


        }


    }

}

@PreviewLightDark
@Composable
private fun AyahOfTheDayPrev() {
    BlQuraanTheme {
     //   AyahOfTheDay()
    }

}