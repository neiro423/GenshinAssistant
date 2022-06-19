package com.saize.genshinassistant.data

import com.saize.genshinassistant.data.model.GenshinCharacter
import com.saize.genshinassistant.domain.GenshinRepository
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.find
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GenshinRepositoryImpl @Inject constructor(
    private val realm: Realm
) : GenshinRepository {
    override suspend fun getCharacterById(characterId: String): GenshinCharacter? = withContext(Dispatchers.IO) {
        realm.query<GenshinCharacter>(
            "customName = $0", characterId
        )
            .first()
            .find()

    }

    override suspend fun getCharacters(): List<GenshinCharacter> = withContext(Dispatchers.IO) {
        realm.query<GenshinCharacter>()
            .find()
            .toList()
    }

    override suspend fun addCharacter(newCharacter: GenshinCharacter) = withContext(Dispatchers.IO) {
        realm.writeBlocking { copyToRealm(newCharacter) }
        Unit
    }

    override suspend fun editCharacter(characterId: String, newCharacter: GenshinCharacter) {
        realm.writeBlocking {
            query<GenshinCharacter>(
                "name = $0", characterId
            ).first()
                .find { character ->
                    character?.apply {
                        artifacts = newCharacter.artifacts
                        weapon = newCharacter.weapon
                        stats = newCharacter.stats
                    }
                }
        }
    }
}