package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacter
import javax.inject.Inject

class GetCharacterCase @Inject constructor(private val repository: GenshinRepository) {
    suspend fun execute(characterId: String): GenshinCharacter? {
        return repository.getCharacterById(characterId)
    }
}