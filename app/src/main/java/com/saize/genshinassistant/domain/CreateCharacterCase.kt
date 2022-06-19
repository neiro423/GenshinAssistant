package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacter
import javax.inject.Inject

class CreateCharacterCase @Inject constructor(
    private val repository: GenshinRepository
) {
    suspend fun execute(character: GenshinCharacter) {
        repository.addCharacter(character)
    }
}