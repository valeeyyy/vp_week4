package com.valerie.vp_week4.Soal2.ui.theme

import androidx.compose.ui.graphics.Color
import com.valerie.vp_week4.Soal2.model.HeroClass
import com.valerie.vp_week4.Soal2.model.Rarity

val PartyBackground = Color(0xFF0E0E16)
val PartySurface = Color(0xFF171722)
val PartySurfaceHigh = Color(0xFF1F1F2D)
val PartyBorder = Color(0xFF2A2A3B)
val PartyTextPrimary = Color(0xFFF4F4F8)
val PartyTextSecondary = Color(0xFF9B9BAF)
val PartyTextMuted = Color(0xFF6E6E82)

val PartyGold = Color(0xFFFBBF24)
val PartyGoldDark = Color(0xFF2A2212)
val PartyGreen = Color(0xFF22C55E)

val HpRed = Color(0xFFF0435A)
val MpBlue = Color(0xFF3B82F6)
val BarTrack = Color(0xFF0B0B12)

val StatAtk = Color(0xFFF0435A)
val StatDef = Color(0xFF4ADE80)
val StatCrit = Color(0xFFFB923C)
val StatSpd = Color(0xFF38BDF8)

val HeroClass.accentColor: Color
    get() = when (this) {
        HeroClass.BERSERKER -> Color(0xFFF0457A)
        HeroClass.ARCHMAGE -> Color(0xFF22D3EE)
        HeroClass.PALADIN -> Color(0xFFF5B82E)
        HeroClass.CLERIC -> Color(0xFF34D399)
        HeroClass.ROGUE -> Color(0xFFD946EF)
    }

val Rarity.color: Color
    get() = when (this) {
        Rarity.MYTHIC -> Color(0xFFF0435A)
        Rarity.LEGENDARY -> Color(0xFFF59E0B)
        Rarity.EPIC -> Color(0xFFA855F7)
        Rarity.RARE -> Color(0xFF3B82F6)
    }