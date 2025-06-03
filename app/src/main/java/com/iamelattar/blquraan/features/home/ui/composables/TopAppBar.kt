package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iamelattar.blquraan.R
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {


    Box(
        modifier = modifier
            .shadow(
                elevation = 1.dp, shape = RoundedCornerShape(
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )
            .padding(bottom = 3.dp)
            .fillMaxWidth()
            .height(130.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(
                    bottomEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )

    ) {


        Image(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        bottomEnd = 30.dp,
                        bottomStart = 30.dp
                    )
                )
                .fillMaxSize(),
            painter = painterResource(R.drawable.islamic_bg),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )

        Row(
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.BottomStart),
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Spacer(Modifier.height(15.dp))
                Image(

                    imageVector = ImageVector.vectorResource(R.drawable.logo),
                    contentDescription = "sa"
                )
            }

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(3.dp)

            ) {
                Text(
                    text = stringResource(R.string.welcome_back),
                    color = Color(0xff187072),
                    style = MaterialTheme.typography.headlineMedium
                )

                IconText(
                    text = "الثلاثاء , 4 صفر 1446",
                    iconResourceId = R.drawable.calender
                )

                IconText(
                    text = "صلاة العصر بعد 3 ساعات و 27 دقيقة",
                    iconResourceId = R.drawable.prayer
                )
            }

        }


    }
}


@Preview(showSystemUi = true)
@Composable
private fun TopAppBarPreview() {
    BlQuraanTheme {
        TopAppBar()
    }

}