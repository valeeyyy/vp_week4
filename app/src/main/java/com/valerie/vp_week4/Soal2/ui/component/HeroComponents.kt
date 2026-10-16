package com.valerie.vp_week4.Soal2.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.valerie.vp_week4.Soal2.model.Hero
import com.valerie.vp_week4.Soal2.model.HeroClass
import com.valerie.vp_week4.Soal2.model.HeroDataSource
import com.valerie.vp_week4.Soal2.ui.theme.BarTrack
import com.valerie.vp_week4.Soal2.ui.theme.HpRed
import com.valerie.vp_week4.Soal2.ui.theme.MpBlue
import com.valerie.vp_week4.Soal2.ui.theme.PartyBackground
import com.valerie.vp_week4.Soal2.ui.theme.PartyBorder
import com.valerie.vp_week4.Soal2.ui.theme.PartyGold
import com.valerie.vp_week4.Soal2.ui.theme.PartySurface
import com.valerie.vp_week4.Soal2.ui.theme.PartySurfaceHigh
import com.valerie.vp_week4.Soal2.ui.theme.PartyTextPrimary
import com.valerie.vp_week4.Soal2.ui.theme.PartyTextSecondary
import com.valerie.vp_week4.Soal2.ui.theme.StatAtk
import com.valerie.vp_week4.Soal2.ui.theme.StatCrit
import com.valerie.vp_week4.Soal2.ui.theme.StatDef
import com.valerie.vp_week4.Soal2.ui.theme.StatSpd
import com.valerie.vp_week4.Soal2.ui.theme.accentColor
import com.valerie.vp_week4.Soal2.ui.theme.color

@Composable
fun HeroCard(
    hero: Hero,
    isInSquad: Boolean,
    isExpanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val chevronRotation by animateFloatAsState(if (isExpanded) 180f else 0f, label = "chevron")

    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = PartySurface),
        border = if (isInSquad) BorderStroke(1.5.dp, PartyGold) else BorderStroke(1.dp, PartyBorder)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Tag(text = hero.rarity.displayName.uppercase(), color = hero.rarity.color, letterSpacing = 0.8)
                Spacer(Modifier.width(6.dp))
                Tag(text = hero.title, color = hero.heroClass.accentColor, filled = true)
                Spacer(Modifier.weight(1f))
                PowerLabel(power = hero.power)
                if (isInSquad) {
                    Spacer(Modifier.width(6.dp))
                    Tag(text = "IN SQUAD", color = PartyGold, letterSpacing = 0.4, rounded = true)
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                HeroAvatar(heroClass = hero.heroClass, size = 76.dp, level = hero.level)
                Spacer(Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = hero.name,
                            color = PartyTextPrimary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = Icons.Filled.ExpandMore,
                            contentDescription = if (isExpanded) "Collapse" else "Expand",
                            tint = PartyTextSecondary,
                            modifier = Modifier
                                .size(22.dp)
                                .rotate(chevronRotation)
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    StatBar(label = "HP", current = hero.hp, max = hero.maxHp, color = HpRed)
                    Spacer(Modifier.height(5.dp))
                    StatBar(label = "MP", current = hero.mp, max = hero.maxMp, color = MpBlue)
                }
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                HeroDetails(hero = hero)
            }
        }
    }
}

@Composable
private fun HeroDetails(hero: Hero) {
    Column {
        Spacer(Modifier.height(14.dp))
        HorizontalDivider(color = PartyBorder, thickness = 1.dp)
        Spacer(Modifier.height(14.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            StatBox("ATK", hero.atk.toString(), StatAtk, Modifier.weight(1f))
            StatBox("DEF", hero.def.toString(), StatDef, Modifier.weight(1f))
            StatBox("CRIT", "${hero.critPercent}%", StatCrit, Modifier.weight(1f))
            StatBox("SPD", hero.spd.toString(), StatSpd, Modifier.weight(1f))
        }
        Spacer(Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(PartySurfaceHigh)
                .border(1.dp, PartyBorder, RoundedCornerShape(10.dp))
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = PartyGold,
                    modifier = Modifier.size(15.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = hero.skillName,
                    color = PartyGold,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(Modifier.height(6.dp))
            Text(
                text = hero.skillDescription,
                color = PartyTextSecondary,
                fontSize = 12.sp,
                lineHeight = 19.sp
            )
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlineActionButton(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = StatDef,
                        modifier = Modifier.size(15.dp)
                    )
                },
                text = "Heal (+250 HP)",
                color = StatDef,
                modifier = Modifier.weight(1f)
            )
            OutlineActionButton(
                icon = { Text(text = "⚔️", fontSize = 15.sp) },
                text = "Add to Squad",
                color = PartyGold,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun HeroAvatar(
    heroClass: HeroClass,
    size: Dp,
    modifier: Modifier = Modifier,
    level: Int? = null,
    cornerRadius: Dp = 10.dp,
    borderWidth: Dp = 2.dp
) {
    val shape = RoundedCornerShape(cornerRadius)
    Box(
        modifier = modifier
            .size(size)
            .clip(shape)
            .background(Color.White)
            .border(borderWidth, heroClass.accentColor, shape)
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(heroClass.imageRes),
            contentDescription = heroClass.displayName,
            contentScale = ContentScale.Crop,
            filterQuality = FilterQuality.None,
            modifier = Modifier
                .matchParentSize()
                .padding(borderWidth)
                .graphicsLayer {
                    scaleX = 1.06f
                    scaleY = 1.06f
                }
        )
        if (level != null) {
            Text(
                text = "Lvl $level",
                color = PartyTextPrimary,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(topStart = 8.dp))
                    .background(PartyBackground.copy(alpha = 0.88f))
                    .padding(start = 7.dp, end = 6.dp, top = 2.dp, bottom = 3.dp)
            )
        }
    }
}

@Composable
fun StatBar(label: String, current: Int, max: Int, color: Color, modifier: Modifier = Modifier) {
    val fraction by animateFloatAsState(
        targetValue = if (max > 0) (current.toFloat() / max).coerceIn(0f, 1f) else 0f,
        label = "statBar"
    )
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            color = PartyTextSecondary,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.width(26.dp)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .height(7.dp)
                .clip(CircleShape)
                .background(BarTrack)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction)
                    .clip(CircleShape)
                    .background(color)
            )
        }
        Spacer(Modifier.width(5.dp))
        Box(
            modifier = Modifier
                .size(4.dp)
                .clip(CircleShape)
                .background(color)
        )
        Text(
            text = "$current / $max",
            color = PartyTextSecondary,
            fontSize = 11.sp,
            textAlign = TextAlign.End,
            modifier = Modifier.width(76.dp)
        )
    }
}

@Composable
fun PowerLabel(power: Int, modifier: Modifier = Modifier, fontSize: Int = 13) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "⚔️", fontSize = fontSize.sp)
        Spacer(Modifier.width(4.dp))
        Text(
            text = "$power CP",
            color = PartyGold,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Tag(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    filled: Boolean = false,
    rounded: Boolean = false,
    letterSpacing: Double = 0.0
) {
    val shape = RoundedCornerShape(if (rounded) 50 else 15)
    Text(
        text = text,
        color = color,
        fontSize = 9.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = letterSpacing.sp,
        modifier = modifier
            .clip(shape)
            .background(color.copy(alpha = if (filled) 0.16f else 0.08f))
            .then(if (filled) Modifier else Modifier.border(1.dp, color.copy(alpha = 0.7f), shape))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    )
}

@Composable
fun ClassFilterChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val background by animateColorAsState(if (selected) Color(0xFF3D2E10) else Color(0xFF161826), label = "chipBg")
    val borderColor by animateColorAsState(if (selected) Color(0xFFFFB301) else Color(0xFF2B2F48), label = "chipBorder")
    val textColor by animateColorAsState(if (selected) Color(0xFFFFB301) else Color(0xFF9EA3B8), label = "chipText")
    Box(
        modifier = modifier
            .height(28.dp)
            .clip(CircleShape)
            .background(background)
            .border(if (selected) 1.5.dp else 1.dp, borderColor, CircleShape)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
        )
    }
}

@Composable
private fun StatBox(label: String, value: String, labelColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(PartySurfaceHigh)
            .border(1.dp, PartyBorder, RoundedCornerShape(8.dp))
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label, color = labelColor, fontSize = 9.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(2.dp))
        Text(text = value, color = PartyTextPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun OutlineActionButton(
    icon: @Composable () -> Unit,
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(10.dp)
    Row(
        modifier = modifier
            .height(40.dp)
            .clip(shape)
            .background(color.copy(alpha = 0.1f))
            .border(1.dp, color.copy(alpha = 0.6f), shape)
            .clickable { },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(Modifier.width(6.dp))
        Text(text = text, color = color, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(name = "Hero card – collapsed / expanded", showBackground = true, backgroundColor = 0xFF0E0E16)
@Composable
private fun HeroCardPreview() {
    val heroes = HeroDataSource.heroes
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        HeroCard(hero = heroes[0], isInSquad = false, isExpanded = true, onClick = {})
        HeroCard(hero = heroes[3], isInSquad = true, isExpanded = false, onClick = {})
    }
}