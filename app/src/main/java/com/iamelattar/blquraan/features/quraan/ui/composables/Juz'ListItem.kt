package com.iamelattar.blquraan.features.quraan.ui.composables

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
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R

@Composable
fun JuzListItem(modifier: Modifier = Modifier) {
    ListItem(
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp)),
        colors = ListItemDefaults.colors(
            containerColor = Color(0xffE7EAEA)
        ),
        headlineContent = {
            Text(
                text =  "الجزء الأول",
                color = Color(0xff187072)
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