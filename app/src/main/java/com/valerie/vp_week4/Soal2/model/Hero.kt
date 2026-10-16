package com.valerie.vp_week4.Soal2.model

import androidx.annotation.DrawableRes
import com.valerie.vp_week4.R

enum class HeroClass(val displayName: String, @DrawableRes val imageRes: Int) {
    BERSERKER("Berserker", R.drawable.berserker),
    ARCHMAGE("Archmage", R.drawable.archmage),
    PALADIN("Paladin", R.drawable.paladin),
    CLERIC("Cleric", R.drawable.cleric),
    ROGUE("Rogue", R.drawable.rogue)
}

enum class Rarity(val displayName: String) {
    MYTHIC("Mythic"),
    LEGENDARY("Legendary"),
    EPIC("Epic"),
    RARE("Rare")
}

data class Hero(
    val id: Int,
    val name: String,
    val heroClass: HeroClass,
    val title: String,
    val rarity: Rarity,
    val level: Int,
    val power: Int,
    val hp: Int,
    val maxHp: Int,
    val mp: Int,
    val maxMp: Int,
    val atk: Int,
    val def: Int,
    val critPercent: Int,
    val spd: Int,
    val skillName: String,
    val skillDescription: String
)