package com.valerie.vp_week4.Soal2.model

object HeroDataSource {

    val heroes = listOf(
        Hero(
            id = 1, name = "Alistair", heroClass = HeroClass.PALADIN, title = "High Templar",
            rarity = Rarity.MYTHIC, level = 50, power = 5600,
            hp = 1650, maxHp = 1800, mp = 650, maxMp = 800,
            atk = 380, def = 540, critPercent = 22, spd = 105,
            skillName = "Wrath of the Heavens",
            skillDescription = "Calls down a celestial hammer, stunning all enemies for 3 seconds and taunting survivors."
        ),
        Hero(
            id = 2, name = "Theresa", heroClass = HeroClass.CLERIC, title = "Divine Oracle",
            rarity = Rarity.MYTHIC, level = 49, power = 5480,
            hp = 1100, maxHp = 1200, mp = 2100, maxMp = 2400,
            atk = 210, def = 320, critPercent = 12, spd = 118,
            skillName = "Hymn of Renewal",
            skillDescription = "Plays a sacred melody that restores 40% HP to all allies and cleanses every debuff."
        ),
        Hero(
            id = 3, name = "Vespera", heroClass = HeroClass.ROGUE, title = "Shadowblade",
            rarity = Rarity.MYTHIC, level = 48, power = 5350,
            hp = 890, maxHp = 950, mp = 410, maxMp = 600,
            atk = 520, def = 190, critPercent = 45, spd = 162,
            skillName = "Phantom Requiem",
            skillDescription = "Vanishes into the shadows and strikes the weakest enemy five times, each hit guaranteed to crit."
        ),
        Hero(
            id = 4, name = "Elaria", heroClass = HeroClass.ARCHMAGE, title = "Archmage",
            rarity = Rarity.MYTHIC, level = 47, power = 5120,
            hp = 450, maxHp = 600, mp = 1850, maxMp = 2000,
            atk = 610, def = 150, critPercent = 30, spd = 110,
            skillName = "Arcane Cataclysm",
            skillDescription = "Unleashes a storm of arcane meteors dealing massive magic damage to every enemy on the field."
        ),
        Hero(
            id = 5, name = "Ragnar", heroClass = HeroClass.BERSERKER, title = "Blood Reaver",
            rarity = Rarity.LEGENDARY, level = 46, power = 4890,
            hp = 2100, maxHp = 2400, mp = 180, maxMp = 400,
            atk = 560, def = 280, critPercent = 28, spd = 98,
            skillName = "Crimson Frenzy",
            skillDescription = "Enters a blood rage, gaining 50% attack and lifesteal for 3 turns at the cost of defense."
        ),
        Hero(
            id = 6, name = "Cedric", heroClass = HeroClass.PALADIN, title = "Oathkeeper",
            rarity = Rarity.LEGENDARY, level = 45, power = 4740,
            hp = 1500, maxHp = 1700, mp = 520, maxMp = 700,
            atk = 340, def = 500, critPercent = 15, spd = 96,
            skillName = "Bulwark of Faith",
            skillDescription = "Raises a holy barrier that absorbs damage for the whole party for 2 turns."
        ),
        Hero(
            id = 7, name = "Seraphine", heroClass = HeroClass.CLERIC, title = "Lightweaver",
            rarity = Rarity.LEGENDARY, level = 44, power = 4510,
            hp = 800, maxHp = 1000, mp = 1650, maxMp = 2000,
            atk = 190, def = 260, critPercent = 10, spd = 112,
            skillName = "Radiant Blessing",
            skillDescription = "Blesses one ally, healing them over time and granting immunity to stun for 2 turns."
        ),
        Hero(
            id = 8, name = "Kael", heroClass = HeroClass.ARCHMAGE, title = "Stormcaller",
            rarity = Rarity.LEGENDARY, level = 43, power = 4380,
            hp = 520, maxHp = 700, mp = 1200, maxMp = 1800,
            atk = 580, def = 140, critPercent = 26, spd = 115,
            skillName = "Thunderlord's Fury",
            skillDescription = "Chains lightning between up to four enemies, with a chance to paralyze each target."
        ),
        Hero(
            id = 9, name = "Nyx", heroClass = HeroClass.ROGUE, title = "Nightstalker",
            rarity = Rarity.EPIC, level = 41, power = 4120,
            hp = 610, maxHp = 850, mp = 300, maxMp = 500,
            atk = 470, def = 170, critPercent = 38, spd = 150,
            skillName = "Venom Dance",
            skillDescription = "Slashes all enemies with poisoned daggers, dealing damage over time for 3 turns."
        ),
        Hero(
            id = 10, name = "Brunhild", heroClass = HeroClass.BERSERKER, title = "Warbringer",
            rarity = Rarity.EPIC, level = 40, power = 3960,
            hp = 1200, maxHp = 2000, mp = 120, maxMp = 350,
            atk = 500, def = 300, critPercent = 20, spd = 92,
            skillName = "Earthsplitter",
            skillDescription = "Slams the ground with a greatsword, knocking back the front row of enemies."
        ),
        Hero(
            id = 11, name = "Orin", heroClass = HeroClass.PALADIN, title = "Shieldbearer",
            rarity = Rarity.EPIC, level = 38, power = 3720,
            hp = 1400, maxHp = 1500, mp = 260, maxMp = 600,
            atk = 290, def = 470, critPercent = 8, spd = 88,
            skillName = "Guardian's Vow",
            skillDescription = "Redirects all damage aimed at the weakest ally to himself for one turn."
        ),
        Hero(
            id = 12, name = "Lyra", heroClass = HeroClass.ARCHMAGE, title = "Frost Sage",
            rarity = Rarity.EPIC, level = 37, power = 3550,
            hp = 280, maxHp = 550, mp = 1500, maxMp = 1600,
            atk = 490, def = 130, critPercent = 18, spd = 104,
            skillName = "Glacial Prison",
            skillDescription = "Encases a single enemy in ice, freezing them for 2 turns and lowering their defense."
        ),
        Hero(
            id = 13, name = "Mira", heroClass = HeroClass.CLERIC, title = "Field Medic",
            rarity = Rarity.RARE, level = 34, power = 3210,
            hp = 650, maxHp = 800, mp = 900, maxMp = 1300,
            atk = 150, def = 220, critPercent = 6, spd = 108,
            skillName = "Mending Touch",
            skillDescription = "Instantly heals the ally with the lowest HP for a moderate amount."
        ),
        Hero(
            id = 14, name = "Silas", heroClass = HeroClass.ROGUE, title = "Cutpurse",
            rarity = Rarity.RARE, level = 32, power = 2980,
            hp = 420, maxHp = 700, mp = 210, maxMp = 400,
            atk = 400, def = 150, critPercent = 32, spd = 140,
            skillName = "Quick Fingers",
            skillDescription = "Steals a buff from an enemy and grants extra gold at the end of the battle."
        )
    )

    val initialSquadIds = listOf(5, 4, 6)

    const val MAX_SQUAD_SIZE = 4
}