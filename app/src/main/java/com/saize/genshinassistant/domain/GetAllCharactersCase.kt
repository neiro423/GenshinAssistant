package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacterData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersCase @Inject constructor(
    private val repository: GenshinRepository
) {
    fun execute(): Flow<List<GenshinCharacterData>> {
        return repository.getCharacters()
    }
}