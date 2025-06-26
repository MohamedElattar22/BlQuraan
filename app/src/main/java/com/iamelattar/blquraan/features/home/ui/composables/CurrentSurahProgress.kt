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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme

@Composable
fun CurrentSurahProgress(
    modifier: Modifier = Modifier,
    onContinueClick:()->Unit,
) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
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
                    "سورة البقرة",
                    color = Color(0xff02B9BD)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    "توقفت عند",
                    fontWeight = FontWeight.Thin,
                    color = Color.White
                )

            }
            Row {
                Text(
                    "20",
                    color = Color(0xff02B9BD)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    "صفحة رقم",
                    fontWeight = FontWeight.Thin,
                    color = Color.White
                )

            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .width(115.dp)
                    .height(26.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable{
                        onContinueClick()
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

