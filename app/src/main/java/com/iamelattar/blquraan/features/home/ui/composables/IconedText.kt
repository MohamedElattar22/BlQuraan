package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun IconText(
    text: String ,
    iconResourceId : Int,
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy (5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        Text(
            color = Color(0xff7B7973) ,
            text = text,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold
        )
        Icon(
            modifier = Modifier.size(14.dp),
            imageVector = ImageVector.vectorResource(iconResourceId),
            tint = Color(0xffB6704E),
            contentDescription = "iconDescription"
        )
    }

}