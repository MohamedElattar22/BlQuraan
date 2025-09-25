package com.iamelattar.blquraan.features.quraan.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.features.quraan.domain.Juz

@Composable
fun JuzListItem(
    modifier: Modifier = Modifier, juz: Juz

) {
//    ListItem(
//        modifier = modifier
//            .padding(5.dp)
//            .clip(RoundedCornerShape(10.dp)),
//        colors = ListItemDefaults.colors(
//            containerColor = Color(0xffE7EAEA)
//        ),
//        headlineContent = {
//            Text(
//                text =  "الجزء الأول",
//                color = Color(0xff187072)
//            )
//        },
//
//        leadingContent = {
//            Box(
//                modifier = Modifier.size(40.dp).clip(
//                    CircleShape
//                )
//
//            ) {
//                Image(
//                    modifier = Modifier.align(Alignment.Center) ,
//                    imageVector = ImageVector.vectorResource(R.drawable.surah_number_ic),
//                    contentDescription = ""
//                )
//                Text(
//                    text =  "1" ,
//                    color = Color(0xff187072) ,
//                    modifier = Modifier.align(Alignment.Center)
//
//                )
//
//            }
//        }
//    )

    Row(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFE7EAEA))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = juz.name, color = Color(0xff187072)
        )
    }


}

//@Preview(showBackground = true)
//@Composable
//private fun JuzListItemPreview() {
//    JuzListItem()
//}