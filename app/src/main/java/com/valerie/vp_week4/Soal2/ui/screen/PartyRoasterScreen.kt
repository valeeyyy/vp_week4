package com.valerie.vp_week4.Soal2.ui.screen

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valerie.vp_week4.Soal2.model.Hero
import com.valerie.vp_week4.Soal2.model.HeroClass
import com.valerie.vp_week4.Soal2.model.HeroDataSource
import com.valerie.vp_week4.Soal2.ui.component.ClassFilterChip
import com.valerie.vp_week4.Soal2.ui.component.HeroAvatar
import com.valerie.vp_week4.Soal2.ui.component.HeroCard
import com.valerie.vp_week4.Soal2.ui.component.PowerLabel
import com.valerie.vp_week4.Soal2.ui.theme.PartyBackground
import com.valerie.vp_week4.Soal2.ui.theme.PartyBorder
import com.valerie.vp_week4.Soal2.ui.theme.PartyGold
import com.valerie.vp_week4.Soal2.ui.theme.PartyGoldDark
import com.valerie.vp_week4.Soal2.ui.theme.PartyGreen
import com.valerie.vp_week4.Soal2.ui.theme.PartySurface
import com.valerie.vp_week4.Soal2.ui.theme.PartyTextMuted
import com.valerie.vp_week4.Soal2.ui.theme.PartyTextPrimary
import com.valerie.vp_week4.Soal2.ui.theme.PartyTextSecondary
import com.valerie.vp_week4.Soal2.viewmodel.PartyRosterUiState
import com.valerie.vp_week4.Soal2.viewmodel.PartyRosterViewModel

@Composable
fun PartyRosterApp(
    modifier: Modifier = Modifier,
    viewModel: PartyRosterViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    LightStatusBarIcons()
    PartyRosterScreen(
        uiState = uiState,
        onSelectClass = viewModel::selectClass,
        onHeroClick = viewModel::toggleExpanded,
        modifier = modifier
    )
}

@Composable
fun PartyRosterScreen(
    uiState: PartyRosterUiState,
    onSelectClass: (HeroClass?) -> Unit,
    onHeroClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val statusBarTop = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val navBarBottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(PartyBackground),
        contentPadding = PaddingValues(
            start = 18.dp,
            end = 18.dp,
            top = statusBarTop + 24.dp,
            bottom = navBarBottom + 20.dp
        )
    ) {
        item { RosterHeader(heroCount = uiState.heroes.size) }
        item {
            Spacer(Modifier.height(16.dp))
            SquadPanel(squad = uiState.squad, squadPower = uiState.squadPower)
        }
        item {
            Spacer(Modifier.height(16.dp))
            SearchBar()
        }
        item {
            Spacer(Modifier.height(12.dp))
            FilterRow(uiState = uiState, onSelectClass = onSelectClass)
            Spacer(Modifier.height(20.dp))
        }
        items(uiState.visibleHeroes, key = { it.id }) { hero ->
            HeroCard(
                hero = hero,
                isInSquad = uiState.isInSquad(hero.id),
                isExpanded = uiState.expandedHeroId == hero.id,
                onClick = { onHeroClick(hero.id) },
                modifier = Modifier
                    .padding(bottom = 14.dp)
                    .animateItem()
            )
        }
    }
}

@Composable
private fun RosterHeader(heroCount: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Party Roster",
                color = PartyTextPrimary,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-0.5).sp
            )
            Text(
                text = "Guild Vanguard • $heroCount Heroes Available",
                color = PartyTextSecondary,
                fontSize = 13.sp
            )
        }
        Row(
            modifier = Modifier
                .clip(CircleShape)
                .background(PartyGoldDark)
                .border(1.dp, PartyGold.copy(alpha = 0.7f), CircleShape)
                .padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = PartyGold,
                modifier = Modifier.size(13.dp)
            )
            Spacer(Modifier.width(6.dp))
            Text(text = "Expedition", color = PartyGold, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
private fun SquadPanel(squad: List<Hero>, squadPower: Int) {
    val shape = RoundedCornerShape(16.dp)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Brush.linearGradient(listOf(Color(0xFF221E33), Color(0xFF1E1A26))))
            .border(
                1.5.dp,
                Brush.linearGradient(listOf(Color(0xFFC29438), Color(0xFF8A5A3A), Color(0xFF6E3550))),
                shape
            )
            .padding(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .clip(CircleShape)
                    .background(PartyGreen)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "EXPEDITION SQUAD (${squad.size}/${HeroDataSource.MAX_SQUAD_SIZE})",
                color = Color(0xFFD4D4DE),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 1.sp,
                modifier = Modifier.weight(1f)
            )
            PowerLabel(power = squadPower, fontSize = 15)
        }
        Spacer(Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                squad.forEach { hero ->
                    HeroAvatar(heroClass = hero.heroClass, size = 46.dp, cornerRadius = 8.dp)
                }
                repeat(HeroDataSource.MAX_SQUAD_SIZE - squad.size) { EmptySquadSlot() }
            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .height(42.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(PartyGold)
                    .clickable { }
                    .padding(horizontal = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Deploy", color = Color(0xFF1A1405), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.Filled.Bolt,
                    contentDescription = null,
                    tint = Color(0xFFFFE27A),
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}

@Composable
private fun EmptySquadSlot() {
    Box(
        modifier = Modifier
            .size(46.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF22222F))
            .border(1.dp, PartyBorder, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add hero",
            tint = PartyTextMuted,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(PartySurface)
            .border(1.dp, PartyBorder, RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            tint = PartyTextSecondary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = "Search by hero name, class, or rarity...",
            color = PartyTextMuted,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun FilterRow(uiState: PartyRosterUiState, onSelectClass: (HeroClass?) -> Unit) {
    val filters: List<HeroClass?> = listOf(null) + HeroClass.entries
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(end = 96.dp)
        ) {
            items(filters) { heroClass ->
                ClassFilterChip(
                    text = "${heroClass?.displayName ?: "All"} (${uiState.countOf(heroClass)})",
                    selected = uiState.selectedClass == heroClass,
                    onClick = { onSelectClass(heroClass) }
                )
            }
        }
        Box(modifier = Modifier.background(PartyBackground).padding(start = 8.dp)) {
            Box(
                modifier = Modifier
                    .height(28.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF1F2237))
                    .border(1.dp, Color(0xFF2B2F48), RoundedCornerShape(10.dp))
                    .clickable { }
                    .padding(horizontal = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Sort: Power",
                    color = Color(0xFFFFB301),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun LightStatusBarIcons() {
    if (LocalInspectionMode.current) return
    val view = LocalView.current
    DisposableEffect(view) {
        val window = (view.context as? Activity)?.window
        val controller = window?.let { WindowCompat.getInsetsController(it, view) }
        val previous = controller?.isAppearanceLightStatusBars
        controller?.isAppearanceLightStatusBars = false
        onDispose { if (previous != null) controller.isAppearanceLightStatusBars = previous }
    }
}

@Preview(name = "Soal 2 - Party Roster", showSystemUi = true, device = "id:pixel_7")
@Composable
private fun PartyRosterAppPreview() {
    PartyRosterApp(viewModel = remember { PartyRosterViewModel() })
}