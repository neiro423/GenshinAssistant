package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacter
import javax.inject.Inject

class UpdateCharacter @Inject constructor(
    private val repository: GenshinRepository
) {
    suspend fun execute(characterName: String, updateCharacter: GenshinCharacter) {
        repository.editCharacter(characterName, updateCharacter)
    }
}