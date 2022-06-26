package com.saize.genshinassistant.domain.model

data class GenshinCharacter(
    val customName: String,
    val name: String,
    val genshinBaseCharacter: GenshinBaseCharacter,
    val artifacts: List<GenshinArtifact>,
    val weapon: GenshinWeapon,
)
