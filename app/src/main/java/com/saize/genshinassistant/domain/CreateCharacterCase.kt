package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacterData
import javax.inject.Inject

class CreateCharacterCase @Inject constructor(
    private val repository: GenshinRepository
) {
    suspend fun execute(character: GenshinCharacterData) {
        repository.addCharacter(character)
    }
}