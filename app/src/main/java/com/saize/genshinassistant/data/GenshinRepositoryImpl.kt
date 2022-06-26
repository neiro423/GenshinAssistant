package com.saize.genshinassistant.data

import com.saize.genshinassistant.data.model.GenshinCharacterData
import com.saize.genshinassistant.domain.GenshinRepository
import com.saize.genshinassistant.domain.model.*
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.find
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GenshinRepositoryImpl @Inject constructor(
    private val realm: Realm
) : GenshinRepository {
    override suspend fun getCharacterById(characterId: String): GenshinCharacter? = withContext(Dispatchers.IO) {
        realm.query<GenshinCharacterData>(
            "customName = $0", characterId
        )
            .first()
            .find()
            ?.let { character ->
                val baseCharacter = character.baseCharacter!!
                val artifacts = character.artifacts!!
                val weaponsData = character.weapon!!

                val baseCharacterDomain = GenshinBaseCharacter(
                    name = baseCharacter.name!!,
                    picture = "empty",
                    rarity = GenshinRarity.values().first { it.stars == baseCharacter.rarity!! },
                    weaponType = GenshinWeaponType.values().first { it.name == baseCharacter.weaponType },
                    talents = emptyList(),
                    stats = baseCharacter.stats.map { pair ->
                        GenshinCharacterStats.values().first { it.name == pair.first!! } to pair.second!!
                    }.toMap()
                )
                val artifactsDomain = artifacts.map { art ->
                    GenshinArtifact(
                        name = art.name!!,
                        picture = "empty",
                        rarity = GenshinRarity.values().first { it.stars == art.rarity!! },
                        level = art.level!!,
                        parentSet = art.parentSet!!,
                        stats = art.stats.map { stat ->
                            GenshinStat.Default(
                                stat.name!!,
                                GenshinArtOp(
                                    operatingStat = GenshinCharacterStats.values()
                                        .first { it.name == stat.value!!.operatingStat!! },
                                    opValue = stat.value!!.opValue!!
                                )
                            )
                        }
                    )
                }
                val weapon = GenshinWeapon(
                    name = weaponsData.name!!,
                    picture = "empty",
                    level = weaponsData.level!!,
                    refineRankLevel = weaponsData.refineRankLevel!!,
                    stats = weaponsData.stats.map { stat ->
                        GenshinStat.Default(
                            stat.name!!,
                            GenshinArtOp(
                                operatingStat = GenshinCharacterStats.values()
                                    .first { it.name == stat.value!!.operatingStat!! },
                                opValue = stat.value!!.opValue!!
                            )
                        )
                    },
                    rarity = GenshinRarity.values().first { it.stars == weaponsData.rarity!! }
                )
                GenshinCharacter(
                    customName = character.customName!!,
                    name = baseCharacterDomain.name,
                    genshinBaseCharacter = baseCharacterDomain,
                    artifacts = artifactsDomain,
                    weapon = weapon
                )
            }

    }

    override fun getCharacters(): Flow<List<GenshinCharacterData>> {

        return realm.query<GenshinCharacterData>()
            .asFlow()
            .flowOn(Dispatchers.IO)
            .map { it.list.toList() }
    }

    override suspend fun addCharacter(newCharacter: GenshinCharacterData) = withContext(Dispatchers.IO) {
        realm.writeBlocking { copyToRealm(newCharacter) }
        Unit
    }

    override suspend fun editCharacter(characterId: String, newCharacter: GenshinCharacterData) {
        realm.writeBlocking {
            query<GenshinCharacterData>(
                "name = $0", characterId
            ).first()
                .find { character ->
                    character?.apply {
                        artifacts = newCharacter.artifacts
                        weapon = newCharacter.weapon
                        baseCharacter = newCharacter.baseCharacter
                    }
                }
        }
    }
}