package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacterData
import javax.inject.Inject

class UpdateCharacter @Inject constructor(
    private val repository: GenshinRepository
) {
    suspend fun execute(characterName: String, updateCharacter: GenshinCharacterData) {
        repository.editCharacter(characterName, updateCharacter)
    }
}