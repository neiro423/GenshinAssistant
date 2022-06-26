package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacterData
import com.saize.genshinassistant.domain.model.GenshinCharacter
import kotlinx.coroutines.flow.Flow

interface GenshinRepository {
    suspend fun getCharacterById(characterId: String): GenshinCharacter?
    suspend fun addCharacter(newCharacter: GenshinCharacterData)
    suspend fun editCharacter(characterId: String, newCharacter: GenshinCharacterData)
    fun getCharacters(): Flow<List<GenshinCharacterData>>
}