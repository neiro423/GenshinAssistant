@file:UseSerializers(RealmListSerializer::class)

package com.saize.genshinassistant.data.model

import com.saize.genshinassistant.data.RealmListSerializer
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

class GenshinCharacterData : RealmObject {
    @PrimaryKey
    var customName: String? = null

    var baseCharacter: GenshinBaseCharacterData? = null

    var artifacts: RealmList<GenshinArtifactData>? = null
    var weapon: GenshinWeaponData? = null
}

@Serializable
class GenshinBaseCharacterData : RealmObject {
    var name: String? = null
    var picture: String? = null
    var rarity: Int? = null
    var weaponType: String? = null
    var level: Int? = null

    var isLevelAscended: Boolean? = null

    var talents: RealmList<GenshinTalentData> = realmListOf()

    var stats: RealmList<GenshinStatPair> = realmListOf()
}

@Serializable
class GenshinArtifactData : RealmObject {
    var name: String? = null
    var picture: String? = null
    var rarity: Int? = null
    var level: Int? = null

    var stats: RealmList<GenshinStatData> = realmListOf()

    var parentSet: String? = null
}

@Serializable
class GenshinWeaponData : RealmObject {
    var name: String? = null
    var picture: String? = null
    var rarity: Int? = null
    var level: Int? = null

    var isLevelAscended: Boolean? = null
    var refineRankLevel: Int? = null

    var stats: RealmList<GenshinStatData> = realmListOf()
}

@Serializable
class GenshinStatData : RealmObject {
    var name: String? = null
    var value: GenshinArtOpData? = null
    var isPeaceSet: Boolean? = null
    var desc: String? = null
    var pieceSetCount: String? = null
}

@Serializable
class GenshinArtOpData : RealmObject {
    var operatingStat: String? = null
    var opValue: Double? = null
}

@Serializable
class GenshinTalentData : RealmObject {
    var name: String? = null
    var level: String? = null

    var ops: RealmList<GenshinArtOpData> = realmListOf()
}

@Serializable
class GenshinStatPair : RealmObject {
    var first: String? = null
    var second: Double? = null
}
