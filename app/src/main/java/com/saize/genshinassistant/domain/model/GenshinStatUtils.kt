package com.saize.genshinassistant.domain.model

sealed class GenshinStat {
    abstract val name: String
    abstract val value: GenshinArtOp

    data class Default(override val name: String, override val value: GenshinArtOp) : GenshinStat()

    data class PieceBonus(
        override val name: String,
        override val value: GenshinArtOp,
        val desc: String,
        val pieceSetCount: String
    ) : GenshinStat()
}

data class GenshinArtOp(
    val operatingStat: GenshinCharacterStats,
    val opValue: Double
)

enum class GenshinCharacterStatGroup {
    BASE_STATS,
    ADVANCED_STATS,
    ELEMENTAL_TYPE,
}