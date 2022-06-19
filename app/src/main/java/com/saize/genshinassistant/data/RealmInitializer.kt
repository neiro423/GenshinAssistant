package com.saize.genshinassistant.data

import android.util.Base64
import com.saize.genshinassistant.data.model.*
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.realmListOf

val charactersIconsPath get() = "/CharacterIcon/"
val artifactsIconsPath get() = "/ArtifactsIcon/"

object RealmHolder {
    val realm: Realm by lazy {
        RealmConfiguration.Builder(
            setOf(
                GenshinStat::class,
                GenshinCharacter::class,
                GenshinArcifact::class,
                GenshinWeapon::class,
                BaseStatsGroup::class
            )
        )
            .deleteRealmIfMigrationNeeded()
            .build()
            .let(Realm::open)
            .also { realm ->
                realm.writeBlocking {
                    copyToRealm(
                        GenshinCharacter().apply {
                            customName = "Хуеплет"
                            name = "Bennet"
                            picture = "${charactersIconsPath}Bennet.png"
                            artifacts = realmListOf(
                                GenshinArcifact().apply {
                                    name = "Залупа"
                                    picture = "${artifactsIconsPath}Royal Flora.png"
                                    mainStat = GenshinStat().apply {
                                        name = "HP"
                                        value = 20.0
                                        desc = null
                                    }
                                    stats = realmListOf(
                                        GenshinStat().apply {
                                            name = "HP%"
                                            value = 20.0
                                            desc = null
                                        }
                                    )
                                })
                            weapon = GenshinWeapon().apply {
                                name = "Lion's Roar"
                                picture = "${artifactsIconsPath}Royal Flora.png"
                                baseAtk = 20.0
                                level = 20
                                refineRankLevel = 5
                                mainStat = GenshinStat().apply {
                                    name = "SomeStat"
                                    value = 30.0
                                }
                                stats = realmListOf(
                                    GenshinStat().apply {
                                        name = "SomeStat"
                                        value = 10.0
                                    }
                                )
                            }
                            stats = BaseStatsGroup().apply {
                                baseStats = realmListOf(
                                    GenshinStat().apply {
                                        name = "SomeStat"
                                        value = 10.0
                                    }
                                )
                                advancedStats = realmListOf(
                                    GenshinStat().apply {
                                        name = "SomeStat"
                                        value = 10.0
                                    }
                                )
                            }

                        }
                    )
                }
            }
    }
}