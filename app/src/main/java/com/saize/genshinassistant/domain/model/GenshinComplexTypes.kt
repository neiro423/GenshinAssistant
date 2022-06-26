package com.saize.genshinassistant.domain.model

/**
 * Эти штуки пойдут с базы
 */
data class GenshinBaseCharacter(
    val name: String,
    val picture: String,
    val rarity: GenshinRarity,
    val weaponType: GenshinWeaponType,
    val talents: List<GenshinTalent>,
    val stats: Map<GenshinCharacterStats, Double>
)

data class GenshinArtifact(
    val name: String,
    val picture: String,
    val rarity: GenshinRarity,
    val level: Int,
    val stats: List<GenshinStat>,
    val parentSet: String
)

data class GenshinWeapon(
    val name: String,
    val picture: String,
    val rarity: GenshinRarity,
    val level: Int,
    val refineRankLevel: Int,
    val stats: List<GenshinStat>
)