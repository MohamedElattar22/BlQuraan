package com.iamelattar.blquraan.features.home.ui.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.features.home.viewmodel.contracts.PrayerTime
import com.iamelattar.blquraan.ui.theme.BlQuraanTheme
import kotlinx.coroutines.delay



@Composable
fun PrayerTimesTimeline(
    prayerTimes: List<PrayerTime>,
    modifier: Modifier = Modifier
) {
    // Animation states
    var animationPlayed by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(
        targetValue = if (animationPlayed) 1f else 0f,
        animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
        label = "timeline_progress"
    )

    // Trigger animation on composition
    LaunchedEffect(Unit) {
        delay(300)
        animationPlayed = true
    }

    // RTL support
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal =  25.dp)

        ) {
            prayerTimes.forEachIndexed { index, prayer ->
                PrayerTimeItem(
                    prayer = prayer,
                    isFirst = index == 0,
                    isLast = index == prayerTimes.lastIndex,
                    animationProgress = animatedProgress,
                    animationDelay = index * 150L
                )
            }
        }
    }
}

@Composable
private fun PrayerTimeItem(
    prayer: PrayerTime,
    isFirst: Boolean,
    isLast: Boolean,
    animationProgress: Float,
    animationDelay: Long
) {
    var itemAnimationPlayed by remember { mutableStateOf(false) }

    // Staggered animation for each item
    LaunchedEffect(Unit) {
        delay(animationDelay)
        itemAnimationPlayed = true
    }

    val slideAnimation by animateFloatAsState(
        targetValue = if (itemAnimationPlayed) 0f else 50f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "slide_animation"
    )

    val fadeAnimation by animateFloatAsState(
        targetValue = if (itemAnimationPlayed) 1f else 0f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing),
        label = "fade_animation"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(x = slideAnimation.dp)
            .graphicsLayer(alpha = fadeAnimation),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Timeline indicator
        TimelineIndicator(
            isActive = prayer.isActive,
            isPassed = prayer.isPassed,
            isFirst = isFirst,
            isLast = isLast,
            animationProgress = animationProgress
        )

        Spacer(modifier = Modifier.width(10.dp))

        // Prayer content
        PrayerContent(
            prayer = prayer,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun TimelineIndicator(
    isActive: Boolean,
    isPassed: Boolean,
    isFirst: Boolean,
    isLast: Boolean,
    animationProgress: Float
) {
    val activeColor = Color(0xFF187072)
    val passedColor = Color(0xFF187072)
    val inactiveColor = Color(0xFFE7EFF2)

    Box(
        modifier = Modifier.size(width = 20.dp, height = 50.dp),
        contentAlignment = Alignment.Center
    ) {
        // Timeline line
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val centerX = size.width / 2
            val lineWidth = 3.dp.toPx()

            // Draw connecting lines
            if (!isFirst) {
                val topProgress = if (isPassed) animationProgress else 0f
                drawLine(
                    color = if (isPassed) passedColor else inactiveColor,
                    start = Offset(centerX, 0f),
                    end = Offset(centerX, size.height /2 * topProgress),
                    strokeWidth = lineWidth
                )
            }

            if (!isLast) {
                val bottomProgress = if (isPassed) animationProgress else 0f
                drawLine(
                    color = if (isPassed) passedColor else inactiveColor,
                    start = Offset(centerX, size.height / 2),
                    end = Offset(centerX, size.height / 2 + (size.height / 2 * bottomProgress)),
                    strokeWidth = lineWidth
                )
            }
        }

        // Center dot with pulse animation for active prayer
        val pulseAnimation by rememberInfiniteTransition(label = "pulse").animateFloat(
            initialValue = 1f,
            targetValue = if (isActive) 1.3f else 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "pulse_scale"
        )

        Box(
            modifier = Modifier
                .size((if (isActive) 16.dp else 12.dp) * pulseAnimation)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val color = when {
                    isActive -> activeColor
                    isPassed -> passedColor
                    else -> inactiveColor
                }

                drawCircle(
                    color = color,
                    radius = size.minDimension / 2
                )

                // Inner white dot for active prayer
                if (isActive) {
                    drawCircle(
                        color = Color.White,
                        radius = size.minDimension / 4
                    )
                }
            }
        }
    }
}

@Composable
private fun PrayerContent(
    prayer: PrayerTime,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(7.dp),
        modifier = modifier.height(38.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (prayer.isActive)
                Color(0xFF187072)
            else
               Color(0xffE7EFF2)
        ),

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Row (

                ){
                    Text(
                        text = prayer.icon,
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = prayer.nameArabic,
                        fontSize = 16.sp,
                        fontWeight = if (prayer.isActive) FontWeight.Bold else FontWeight.Medium,
                        color = if (prayer.isActive) Color.White else Color(0xFF1A7E5C),
                        textAlign = TextAlign.Start
                    )
                }

            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = prayer.time,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (prayer.isActive) Color.White else Color(0xFF1A7E5C)
                )

                Spacer(modifier = Modifier.width(8.dp))

            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun PrayerTimesTimelinePreview() {
    BlQuraanTheme {
        val samplePrayerTimes = listOf(
            PrayerTime("الفجر", "Fajr", "5:15", "🌙", isPassed = true),
            PrayerTime("الشروق", "Sunrise", "6:44", "🌅", isPassed = true),
            PrayerTime("الظهر", "Dhuhr", "12:53", "☀️", isPassed = true),
            PrayerTime("العصر", "Asr", "4:22", "☀️" ,  isActive = true),
            PrayerTime("المغرب", "Maghrib", "7:01", "🌅"),
            PrayerTime("العشاء", "Isha", "8:20", "🌙")
        )

        PrayerTimesTimeline(prayerTimes = samplePrayerTimes)
    }
}