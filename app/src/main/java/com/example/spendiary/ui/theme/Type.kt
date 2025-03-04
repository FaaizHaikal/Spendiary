package com.example.spendiary.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spendiary.R

var InterFont = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_thin, FontWeight.Thin),
    Font(R.font.inter_light, FontWeight.Light)
)

val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = InterFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        color = White87
    ),
    bodySmall = TextStyle(
        fontFamily = InterFont,
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        color = White60
    ),
    titleLarge = TextStyle(
        fontFamily = InterFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
)