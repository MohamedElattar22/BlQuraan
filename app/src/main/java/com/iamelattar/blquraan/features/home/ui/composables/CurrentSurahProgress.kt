package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme

@Composable
fun CurrentSurahProgress(modifier: Modifier = Modifier,souraName:String,pageNumber:String) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .height(125.dp)
           .clip(
                shape = RoundedCornerShape(10.dp)
            )
    ){
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
                "متابعة القراءة حيث توقفت",
                color = Color.White
            )
            Row {

                Text(
                    text = "توقفت عند",
                    color = Color(0xB3FFFFFF),
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 14.sp,
                    modifier = Modifier.alignByBaseline()
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    "سورة ${souraName}",
                    color = Color(0xff02B9BD),
                    modifier = Modifier.alignByBaseline()
                )
            }

            Row {
                Text(
                    "صفحة رقم",
                    color = Color(0xB3FFFFFF),
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 14.sp,
                    modifier = Modifier.alignByBaseline()
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    pageNumber,
                    color = Color(0xff02B9BD),
                    modifier = Modifier.alignByBaseline()
                )

            }

            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .width(115.dp)
                    .height(30.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable{

                }
            ){
                Text(
                    modifier = Modifier.align(Alignment.Center),
                  text =   "المتابعة",
                    style = MaterialTheme.typography.labelSmall
                )

            }

        }



    }


}

@Preview
@Composable
private fun CurrentPR() {
    BlQuraanTheme {
        //CurrentSurahProgress()
    }
}