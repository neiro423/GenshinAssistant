package com.saize.genshinassistant

import android.app.Application
import com.saize.genshinassistant.data.RealmHolder
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        RealmHolder.init(this)
    }
}