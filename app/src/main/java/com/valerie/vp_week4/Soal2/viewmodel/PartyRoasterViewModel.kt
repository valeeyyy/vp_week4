package com.valerie.vp_week4.Soal2.viewmodel

import androidx.lifecycle.ViewModel
import com.valerie.vp_week4.Soal2.model.Hero
import com.valerie.vp_week4.Soal2.model.HeroClass
import com.valerie.vp_week4.Soal2.model.HeroDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class PartyRosterUiState(
    val heroes: List<Hero> = emptyList(),
    val squadIds: List<Int> = emptyList(),
    val selectedClass: HeroClass? = null,
    val expandedHeroId: Int? = null
) {
    val squad: List<Hero> get() = squadIds.mapNotNull { id -> heroes.firstOrNull { it.id == id } }
    val squadPower: Int get() = squad.sumOf { it.power }

    val visibleHeroes: List<Hero>
        get() = if (selectedClass == null) heroes else heroes.filter { it.heroClass == selectedClass }

    fun countOf(heroClass: HeroClass?): Int =
        if (heroClass == null) heroes.size else heroes.count { it.heroClass == heroClass }

    fun isInSquad(heroId: Int) = heroId in squadIds
}

class PartyRosterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        PartyRosterUiState(
            heroes = HeroDataSource.heroes.sortedByDescending { it.power },
            squadIds = HeroDataSource.initialSquadIds
        )
    )
    val uiState: StateFlow<PartyRosterUiState> = _uiState.asStateFlow()

    fun selectClass(heroClass: HeroClass?) {
        _uiState.update { it.copy(selectedClass = heroClass) }
    }

    fun toggleExpanded(heroId: Int) {
        _uiState.update {
            it.copy(expandedHeroId = if (it.expandedHeroId == heroId) null else heroId)
        }
    }
}