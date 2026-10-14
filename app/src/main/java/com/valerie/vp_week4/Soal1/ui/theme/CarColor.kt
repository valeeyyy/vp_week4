package com.valerie.vp_week4.Soal1.ui.theme

import androidx.compose.ui.graphics.Color
import com.valerie.vp_week4.Soal1.model.FuelType

val CarBackground = Color(0xFFF2F0EB)
val CarSurface = Color(0xFFFFFFFF)
val CarBorder = Color(0xFFE6E4DF)
val CarChipBorder = Color(0xFFE9E9EA)
val CarOrange = Color(0xFFFB6B42)
val CarOrangeLight = Color(0xFFFFEFE9)
val CarOrangeBorder = Color(0xFFFFC2AE)
val CarTextPrimary = Color(0xFF0C1929)
val CarTextSecondary = Color(0xFF77818F)
val CarTextMileage = Color(0xFF8E97A3)
val CarTextMuted = Color(0xFFAEB4BF)
val CarImageBackground = Color(0xFFF6F4F0)
val CarChipBackground = Color(0xFFF5F5F6)

data class FuelBadgeColors(val background: Color, val content: Color)

fun FuelType.badgeColors(): FuelBadgeColors = when (this) {
    FuelType.PETROL -> FuelBadgeColors(Color(0xFFFEF6E0), Color(0xFFE68639))
    FuelType.PHEV -> FuelBadgeColors(Color(0xFFEDE8F8), Color(0xFF44259F))
    FuelType.HYBRID -> FuelBadgeColors(Color(0xFFDDF0EE), Color(0xFF36746A))
    FuelType.ELECTRIC -> FuelBadgeColors(Color(0xFFE3F4E4), Color(0xFF2E7D3A))
    FuelType.DIESEL -> FuelBadgeColors(Color(0xFFFDE5E1), Color(0xFFD8452F))
}