package com.saize.genshinassistant.domain

import com.saize.genshinassistant.domain.model.GenshinCharacter
import com.saize.genshinassistant.domain.model.GenshinCharacterStats
import javax.inject.Inject

class GetCharacterCase @Inject constructor(private val repository: GenshinRepository) {
    suspend fun execute(characterId: String): Pair<GenshinCharacter, Map<GenshinCharacterStats, Double>>? {
        return repository.getCharacterById(characterId).let { character ->
            character ?: return@let null

            val grouped = character.artifacts
                .map { it.stats }
                .flatten()
                .plus(character.weapon.stats)
                .groupBy { it.name }

            character to character.genshinBaseCharacter.stats.map { (keyStat, value) ->
                keyStat to (value + (grouped[keyStat.name]?.sumOf { it.value.opValue } ?: 0.0))
            }.toMap()
        }
    }
}