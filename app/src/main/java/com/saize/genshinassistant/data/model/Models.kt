package com.saize.genshinassistant.data.model

import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class GenshinCharacter : RealmObject {
    var customName: String? = null
    var name: String? = null
    var picture: String? = null
    var artifacts: RealmList<GenshinArcifact>? = null
    var weapon: GenshinWeapon? = null
    var stats: BaseStatsGroup? = null
}

class GenshinArcifact : RealmObject {
    var name: String? = null
    var picture: String? = null
    var mainStat: GenshinStat? = null
    var stats: RealmList<GenshinStat>? = null
}


class GenshinWeapon : RealmObject {
    var name: String? = null
    var picture: String? = null
    var baseAtk: Double? = null
    var level: Int? = null
    var refineRankLevel: Int? = null
    var mainStat: GenshinStat? = null
    var stats: RealmList<GenshinStat>? = null
}

class BaseStatsGroup : RealmObject {
    var baseStats: RealmList<GenshinStat>? = null
    var advancedStats: RealmList<GenshinStat>? = null
}

class GenshinStat : RealmObject {
    var name: String? = null
    var value: Double? = null
    var desc: String? = null
}