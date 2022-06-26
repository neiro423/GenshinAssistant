@file:OptIn(ExperimentalSerializationApi::class)

package com.saize.genshinassistant.data

import android.content.Context
import com.saize.genshinassistant.data.model.*
import com.saize.genshinassistant.domain.model.GenshinBaseCharacter
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.types.RealmObject
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

val charactersIconsPath get() = "/CharacterIcon/"
val artifactsIconsPath get() = "/ArtifactsIcon/"

val charactersInitPath get() = "base_characters/"
val artifactsInitPath get() = "artifacts/"
val weaponInitPath get() = "weapons/"

object RealmHolder {
    private val config =
        RealmConfiguration.Builder(
            setOf(
                GenshinCharacterData::class,
                GenshinBaseCharacterData::class,
                GenshinArtifactData::class,
                GenshinStatData::class,
                GenshinWeaponData::class,
                GenshinArtOpData::class,
                GenshinTalentData::class,
                GenshinStatPair::class
            )
        )
            .deleteRealmIfMigrationNeeded()
            .build()

    val realm: Realm by lazy { Realm.open(config) }

    fun init(context: Context) {
        val count = realm.query<GenshinBaseCharacterData>().count().find()
        if (count > 0L) return
        val characters = context.getFromAssets<GenshinBaseCharacterData>(charactersInitPath)
        val artifact = context.getFromAssets<GenshinArtifactData>(artifactsInitPath)
        val weapons = context.getFromAssets<GenshinWeaponData>(weaponInitPath)
        val everything = listOf(characters, artifact, weapons).flatten()
        realm.writeBlocking {
            everything.forEach(::copyToRealm)
            GenshinCharacterData().apply {
                customName = "My Bennet"
                artifacts = artifact.toRealmList()
                weapon = weapons.firstOrNull()
                baseCharacter = characters.firstOrNull()
            }.also(::copyToRealm)
        }
    }

    inline fun <reified T : RealmObject> Context.getFromAssets(path: String): List<T> {
        val files = assets.list(path)
        return when {
            files.isNullOrEmpty() -> emptyList()

            else -> files.map {
                assets.open("$path$it")
                    .let { stream -> Json.decodeFromStream(stream) }
            }
        }
    }

    fun clear() {
        realm.close()
        Realm.deleteRealm(config)
    }
}