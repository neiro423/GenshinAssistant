package com.saize.genshinassistant.domain

import com.saize.genshinassistant.data.model.GenshinCharacter

interface GenshinRepository {
    suspend fun getCharacterById(characterId: String): GenshinCharacter?
    suspend fun addCharacter(newCharacter: GenshinCharacter)
    suspend fun editCharacter(characterId: String, newCharacter: GenshinCharacter)
    suspend fun getCharacters(): List<GenshinCharacter>
}