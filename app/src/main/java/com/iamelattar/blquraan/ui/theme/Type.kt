package com.iamelattar.blquraan.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iamelattar.blquraan.R

val mainFontFamily = FontFamily(
    Font(
        resId = R.font.ui_regular,
    )
)
val mcs0 = FontFamily(Font(R.font.mcs_0))
val mcs1 = FontFamily(Font(R.font.mcs_1))
val mcs2 = FontFamily(Font(R.font.mcs_2))
val mcs3 = FontFamily(Font(R.font.mcs_3))
val mcs4 = FontFamily(Font(R.font.mcs_4))

val typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.8.sp // 120% of font size
    ),
    headlineMedium = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 21.6.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 25.2.sp // 140%
    ),
    bodyMedium = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        lineHeight = 20.8.sp
    ),
    bodySmall = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 18.2.sp
    ),
    labelLarge = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelMedium = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    displaySmall = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    displayMedium = TextStyle(
        fontFamily = mainFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )
)

