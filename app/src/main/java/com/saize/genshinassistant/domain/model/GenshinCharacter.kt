package com.saize.genshinassistant.domain.model

data class GenshinCharacter(
    val customName: String,
    val name: String,
    val picture: String,
    val artifacts: List<GenshinArcifact>,
    val weapon: GenshinWeapon,
    val stats: BaseStatsGroup
)

data class GenshinArcifact(
    val name: String,
    val picture: String,
    val mainStat: GenshinStat,
    val stats: List<GenshinStat>
)

data class GenshinWeapon(
    val name: String,
    val picture: String,
    val baseAtk: Double,
    val level: Int,
    val refineRankLevel: Int,
    val mainStat: GenshinStat,
    val stats: List<GenshinStat>
)

data class BaseStatsGroup(
    val baseStats: List<GenshinStat>,
    val advancedStats: List<GenshinStat>
)

data class GenshinStat(
    val name: String,
    val value: Double,
    val desc: String,
)