package com.saize.genshinassistant.domain.model

class GenshinLevel(val value: Int, val isAscended: Boolean)

class GenshinTalent(val name: String, val ops: List<GenshinArtOp>)

enum class GenshinRarity(val stars: Int) { ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5) }

enum class GenshinWeaponType {
    SWORD,
    CLAYMORE,
    BOW,
    CATALYST,
    POLEARM
}

enum class GenshinCharacterStats(val parentGroup: GenshinCharacterStatGroup) {

    // Base stats
    HP(GenshinCharacterStatGroup.BASE_STATS),
    CHAR_ATK(GenshinCharacterStatGroup.BASE_STATS),
    DEF(GenshinCharacterStatGroup.BASE_STATS),
    ELEMENTAL_MASTERY(GenshinCharacterStatGroup.BASE_STATS),
    HP_PERCENT(GenshinCharacterStatGroup.BASE_STATS),
    BONUS_ATK_PERCENT(GenshinCharacterStatGroup.BASE_STATS),
    DEF_PERCENT(GenshinCharacterStatGroup.BASE_STATS),

    // Advanced stats
    CRIT_PERCENT(GenshinCharacterStatGroup.ADVANCED_STATS),
    CRIT_DMG(GenshinCharacterStatGroup.ADVANCED_STATS),
    HEAL(GenshinCharacterStatGroup.ADVANCED_STATS),
    INCOMING_HEAL(GenshinCharacterStatGroup.ADVANCED_STATS),
    ENERGY_RECHARGE(GenshinCharacterStatGroup.ADVANCED_STATS),
    REDUCE_CD(GenshinCharacterStatGroup.ADVANCED_STATS),
    POWERFUL_SHIELD(GenshinCharacterStatGroup.ADVANCED_STATS),

    // Elemental type
    PYRO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    PYRO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    HYDRO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    HYDRO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    DENDRO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    DENDRO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    ELECTRO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    ELECTRO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    ANEMO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    ANEMO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    CRIO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    CRIO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    GEO_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    GEO_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    PHYSICAL_DMG(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
    PHYSICAL_RES(GenshinCharacterStatGroup.ELEMENTAL_TYPE),
}
